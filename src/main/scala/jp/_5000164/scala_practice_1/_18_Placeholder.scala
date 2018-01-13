package jp._5000164.scala_practice_1

/**
  * To learn Placeholder Syntax
  *
  * Refine list
  */
object _18_Placeholder extends App {
  val someNumbers = List(-2, -1, 0, 1, 2)

  println(someNumbers)
  // List(-2, -1, 0, 1, 2)

  println(someNumbers.filter((x: Int) => x > 0))
  // List(1, 2)

  println(someNumbers.filter(x => x > 0))
  // List(1, 2)

  println(someNumbers.filter(_ > 0))
  // List(1, 2)
}
