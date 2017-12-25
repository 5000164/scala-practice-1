package jp._5000164.scala_practice_1

/**
  * シンボルの使い方について学ぶ
  *
  * String のインスタンスと Symbol のインスタンスを生成して比較してみる
  */
object _11_Symbol extends App {
  // String のインスタンスは違うオブジェクトなので同一性の比較では異なる判定になる
  val string1 = new String("string")
  val string2 = new String("string")
  println(string1 eq string2)
  // false

  // Symbol のインスタンスは同じオブジェクトなので同一性の比較で一致する
  // シンボルリテラルは先頭に ' をつけて書く
  // シンボルのコンパニオンオブジェクトを使用してもインスタンスを生成できる
  val symbol1 = 'symbol
  val symbol2 = Symbol("symbol")
  println(symbol1 eq symbol2)
  // true
}
