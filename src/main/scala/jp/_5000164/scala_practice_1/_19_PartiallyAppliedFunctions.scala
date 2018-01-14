package jp._5000164.scala_practice_1

/**
  * To learn partially applied functions.
  *
  * Make sum partially applied function.
  * Apply partially applied function to foreach.
  */
object _19_PartiallyAppliedFunctions extends App {
  def sum(a: Int, b: Int, c: Int) = a + b + c

  val a = sum _
  println(a(1, 2, 3))
  // 6

  val b = sum(1, 2, _: Int)
  println(b(5))
  // 8

  val c = a(1, _: Int, _: Int)
  println(c(5, 7))
  // 13

  val d = c(9, _: Int)
  println(d(11))
  // 21

  List(1, 2, 3).foreach(println)
  // 1
  // 2
  // 3
}
