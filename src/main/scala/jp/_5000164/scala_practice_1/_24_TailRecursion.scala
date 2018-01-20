package jp._5000164.scala_practice_1

/**
  * To learn tail recursion.
  *
  * 末尾再帰関数とそうではない再帰関数を作って
  * 末尾再帰関数では呼び出し回数が多くなってもエラーにならないことを確認する。
  */
object _24_TailRecursion extends App {
  def notTailRecursion(x: Int): Int =
    if (x <= 0) 0
    else notTailRecursion(x - 1) + 1

  notTailRecursion(10)
  // notTailRecursion(100000000) // エラーになる

  def tailRecursion(x: Int): Int =
    if (x <= 0) 0
    else tailRecursion(x - 1)

  tailRecursion(10)
  tailRecursion(100000000) // エラーにならない
}
