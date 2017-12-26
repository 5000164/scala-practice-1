package jp._5000164.scala_practice_1

/**
  * クラスの設計について学ぶため
  *
  * 分数を扱うクラスを実装することで設計について学ぶ
  */
object _12_Rational extends App {
  val x = new Rational(1, 2)
  println(x.toString)

  // new Rational(1, 0) // エラーとなる

  val y = new Rational(3, 4)
  println(x add y)

  class Rational(n: Int, d: Int) {
    require(d != 0)
    val number: Int = n
    val denom: Int = d

    println(s"Created $number/$denom")

    override def toString = s"$number/$denom"

    def add(that: Rational): Rational =
      new Rational(
        number * that.denom + that.number * denom,
        denom * that.denom
      )
  }

}
