package jp._5000164.scala_practice_1

object _4_Tuple extends App {
  // タプルは異なる型を持つことができる
  val pair = (1, "1")

  // 要素にアクセスするには _1, _2 のようにアクセスする
  // 0 からではなく 1 から始まっているのは伝統によるもの
  println(pair._1) // 1
  println(pair._2) // 1

  // 型が異なっていることを確認する
  // 型を確認するためにはオブジェクトの getClass メソッドを使用する
  println(pair._1.getClass) // int
  println(pair._2.getClass) // class java.lang.String

  // -> メソッドは Scala のすべてのオブジェクトから呼び出せるメソッドで、キーと値を格納する 2 要素のタプルを返す
  // implicit conversion についての詳細は後々やる
  println(1 -> "1") // (1,1)
  println(1.->("1")._1.getClass) // int
  println(1.->("1")._2.getClass) // class java.lang.String
}
