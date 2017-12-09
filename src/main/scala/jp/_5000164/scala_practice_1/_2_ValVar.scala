package jp._5000164.scala_practice_1

object _2_ValVar extends App {
  val valMessage = "Hello, world!"
  // valMessage = "Hello again, world!" // 再代入不可でエラー
  println(valMessage)

  var varMessage = "Hello, world!"
  varMessage = "Hello again, world!"
  println(varMessage)
}
