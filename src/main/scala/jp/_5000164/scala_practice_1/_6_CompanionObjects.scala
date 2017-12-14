package jp._5000164.scala_practice_1

/**
  * コンパニオンオブジェクトについて学ぶ
  *
  * 渡した文字列を空白区切りにした文字列を返す処理を実装
  * 一度渡した文字列は再計算せずにキャッシュから取得していることを確認する
  * コンパニオンオブジェクトはコンパニオンクラスの非公開メンバーにアクセスできることを確認する
  * コンパニオンオブジェクトではないシングルトンオブジェクトからは非公開メンバーにアクセスできないことを確認する
  */
object _6_CompanionObjects extends App {
  // Scala では静的メンバーを持てないので、シングルトンオブジェクトを持っている
  // シングルトンオブジェクトは object キーワードで定義する
  // クラスと同名のシングルトンオブジェクトをコンパニオンオブジェクトと呼び、同名のクラスをコンパニオンクラスと呼ぶ
  // コンパニオンクラスとコンパニオンオブジェクトは同一ソースファイル内で定義しなければならない
  // コンパニオンクラスとコンパニオンオブジェクトは互いの非公開メンバーにアクセスできる
  // シングルトンオブジェクトはパラメーターをとることができない
  // シングルトンオブジェクトは初めてアクセスされた時に初期化される
  // コンパニオンクラスと名前を共有しないシングルトンオブジェクトのことをスタンドアロンオブジェクトと呼ぶ
  // 継承については後々やる

  // キャッシュがまだなにもないことを確認する
  // シングルトンオブジェクトなのでこの時に初期化される
  println(SpacerAccumulator.get()) // Map()

  // 一度使用した文字列をキャッシュから取得していることを確認する
  println(SpacerAccumulator.spacing("Hello, world!")) // spaced: H e l l o ,   w o r l d !
  println(SpacerAccumulator.spacing("Hello, world!")) // spaced: H e l l o ,   w o r l d ! by cache
  println(SpacerAccumulator.spacing("Hello again, world!")) // spaced: H e l l o   a g a i n ,   w o r l d !

  // 使用した文字列がキャッシュされているか確認する
  println(SpacerAccumulator.get()) // Map(Hello, world! -> spaced: H e l l o ,   w o r l d !, Hello again, world! -> spaced: H e l l o   a g a i n ,   w o r l d !)

  // コンパニオンオブジェクトではないので非公開メンバーにアクセスできないことを確認する
  Tester.assertNoAccess()
}

class SpacerAccumulator {
  private var s = "spaced:"
  val publicString = "accessible"

  // TODO: 副作用について書く
  def combine(c: Char, spacer: String): Unit = s += spacer + c

  def combined(): String = s
}

import scala.collection.mutable

object SpacerAccumulator {
  // 初めてアクセスされた時だけ初期化されることを確認する
  println("初期化") // 初期化

  private val cache = mutable.WeakHashMap.empty[String, String]

  // 単一の結果式を計算する場合は中括弧を省略できる
  def spacing(s: String): String =
    if (cache.contains(s))
      cache(s) + " by cache"
    else {
      val sa = new SpacerAccumulator

      // コンパニオンオブジェクトなので private なフィールドでもアクセスできる
      println("default value is " + sa.s) // default value is spaced:

      for (c <- s)
        sa.combine(c, " ")
      val result = sa.combined()
      cache += (s -> result)
      result
    }

  def get(): mutable.WeakHashMap[String, String] = cache
}

object Tester {
  def assertNoAccess(): Unit = {
    val sa = new SpacerAccumulator

    // private なフィールドなのでアクセスできない
    // println(sa.s)

    // private なフィールドではないのでアクセスできる
    println(sa.publicString) // accessible
  }
}
