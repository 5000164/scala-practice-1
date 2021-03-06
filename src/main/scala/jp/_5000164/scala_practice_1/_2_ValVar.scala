package jp._5000164.scala_practice_1

/**
  * val と var の使い方を確認する
  *
  * 代入を行ってみて再代入可能か確認する
  */
object _2_ValVar extends App {
  // val は再代入不可
  val valMessage = "Hello, world!"
  // valMessage = "Hello again, world!" // 再代入不可でエラー
  println(valMessage) // Hello, world!

  // var は再代入可能
  var varMessage = "Hello, world!"
  varMessage = "Hello again, world!"
  println(varMessage) // Hello again, world!
}
