package jp._5000164.scala_practice_1

object _6_CompanionObjects extends App {
  // TODO: コンパニオンオブジェクトについてもっと調べる

  val accumulator = new SpacerAccumulator
  // println(accumulator.s) // private なフィールドなのでアクセスできない

  println(SpacerAccumulator.spacing("Hello, world!"))
  println(SpacerAccumulator.spacing("Hello, world!"))
}

class SpacerAccumulator {
  private var s = ""

  // TODO: 副作用について書く
  def combine(c: Char, spacer: String): Unit = s += spacer + c

  def combined(): String = s
}

import scala.collection.mutable

object SpacerAccumulator {
  // TODO: WeakHashMap がどのような挙動をするのか調べる
  private val cache = mutable.WeakHashMap.empty[String, String]

  // TODO: 同じ文字列を渡した場合にキャッシュが使われるか確認する
  def spacing(s: String): String =
    if (cache.contains(s))
    // println("cached") // 単一の結果式ではなくなるので中括弧を使用しないとエラーになる
      cache(s)
    else {
      val accumulator = new SpacerAccumulator
      println(accumulator.s) // コンパニオンオブジェクトなので private なフィールドでもアクセスできる
      for (c <- s)
        accumulator.combine(c, " ")
      val result = accumulator.combined()
      cache += (s -> result)
      result
    }
}
