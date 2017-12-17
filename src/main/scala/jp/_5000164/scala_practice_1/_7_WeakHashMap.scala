package jp._5000164.scala_practice_1

import scala.collection.mutable
import scala.compat.Platform

object _7_WeakHashMap extends App {
  private val cache = mutable.WeakHashMap.empty[String, String]
  private val keys = mutable.Map(1 -> "one", 2 -> "two", 3 -> "three")

  println("初期値")
  println(keys)
  println(cache)

  cache += (keys(1) -> "one")
  cache += (keys(2) -> "two")
  cache += (keys(3) -> "three")

  println("")
  println(keys)
  println(cache)

  keys -= 1

  println("")
  println(keys)
  println(cache)

  Platform.collectGarbage

  // TODO: WeakHashMap の要素がなぜ消えないのか調べる
  println("")
  println(keys)
  println(cache)
}
