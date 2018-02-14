package jp._5000164.scala_practice_1

/**
  * To learn by-name parameters.
  */
object _27_ByNameParameters extends App {
  def func3(func: (Int, Int, Int) => Boolean): Boolean = func(1, 2, 3)

  def func2(func: (Int, Int) => Boolean): Boolean = func(1, 2)

  def func1(func: (Int) => Boolean): Boolean = func(1)

  def func0(func: () => Boolean): Boolean = func()

  def funcByNameParameters(func: => Boolean) = func

  func3((x, y, z) => x + y + z > 0)
  func2((x, y) => x + y > 0)
  func1((x) => x > 0)
  func0(() => 1 > 0)
  funcByNameParameters(1 > 0)
}
