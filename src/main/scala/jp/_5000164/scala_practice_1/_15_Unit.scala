package jp._5000164.scala_practice_1

/**
  * Unit について学ぶため
  *
  * Unit 値での比較を試してみる
  */
object _15_Unit extends App {
  var test = "test"
  val unit: Unit = test = "retest"
  println(unit)
  // ()

  println(() == unit)
  // true
  println(() == print(""))
  // true

  def noReturn(): Unit = {print("")}

  println(() == noReturn())
  // true
}
