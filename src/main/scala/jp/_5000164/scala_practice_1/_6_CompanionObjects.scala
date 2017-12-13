package jp._5000164.scala_practice_1

object _6_CompanionObjects extends App {
  // TODO: コンパニオンオブジェクトについてもっと調べる

  println(SpacerAccumulator.get()) // Map()

  println(SpacerAccumulator.spacing("Hello, world!")) // spaced: H e l l o ,   w o r l d !
  println(SpacerAccumulator.spacing("Hello, world!")) // spaced: H e l l o ,   w o r l d ! by cache
  println(SpacerAccumulator.spacing("Hello again, world!")) // spaced: H e l l o   a g a i n ,   w o r l d !

  println(SpacerAccumulator.get()) // Map(Hello, world! -> spaced: H e l l o ,   w o r l d !, Hello again, world! -> spaced: H e l l o   a g a i n ,   w o r l d !)

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
  // TODO: WeakHashMap がどのような挙動をするのか調べる
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
