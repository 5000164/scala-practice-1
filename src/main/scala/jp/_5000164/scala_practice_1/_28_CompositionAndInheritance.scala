package jp._5000164.scala_practice_1

object _28_CompositionAndInheritance extends App {

  abstract class Element {
    def contents: Array[String]

    def height: Int = contents.length

    def width: Int = if (height == 0) 0 else contents(0).length
  }

  // パラメーターなしメソッドはフィールドでオーバーライドすることができる
  // よってパラメーターフィールドで簡略化して記述することができる
  class ArrayElement(val contents: Array[String]) extends Element

}
