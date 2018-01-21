package jp._5000164.scala_practice_1

/**
  * To learn currying.
  */
object _26_Currying extends App {
  def plainOldSum(x: Int, y: Int) = x + y

  println(plainOldSum(1, 2))

  def curriedSum(x: Int)(y: Int) = x + y

  println(curriedSum(1)(2))
}
