package jp._5000164.scala_practice_1

/**
  * クラスの設計について学ぶため
  *
  * 分数を扱うクラスを実装することで設計について学ぶ
  */
object _12_Rational extends App {

  class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val number = n / g
    val denom = d / g

    def this(n: Int) = this(n, 1)

    def +(that: Rational): Rational =
      new Rational(
        number * that.denom + that.number * denom,
        denom * that.denom
      )

    def *(that: Rational): Rational =
      new Rational(
        number * that.number,
        denom * that.denom
      )

    override def toString = s"$number/$denom"

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }

  val x = new Rational(1, 2)
  println(s"x: ${x.getClass} = $x")

  // new Rational(1, 0) // エラーとなる

  val y = new Rational(3)
  println(s"y: ${y.getClass} = $y")

  val z = new Rational(66, 99)
  println(s"z: ${z.getClass} = $z")

  println(x + y)
  println(y * z)
  println(x + y * z)
}
