package jp._5000164.scala_practice_1

import scala.collection.mutable
import scala.compat.Platform

object _7_WeakHashMap extends App {
  // TODO: WeakHashMap がどのような挙動をするのか調べる

  private val cache = mutable.WeakHashMap.empty[String, String]
  println(cache)
  Platform.collectGarbage
  println(cache)
}
