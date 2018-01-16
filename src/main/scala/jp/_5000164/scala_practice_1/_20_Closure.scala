package jp._5000164.scala_practice_1

/**
  * To learn Closure.
  *
  * Make simple Closure.
  */
object _20_Closure extends App {
  var more = 10
  val addMore = (_: Int) + more
  println(addMore(10))
  // 20

  more = 100
  println(addMore(10))
  // 110

  more = 10
  val addToMore = more += (_: Int)
  addToMore(10)
  println(more)
  // 20

  // Closure を生成する
  def makeIncreaser(m: Int) = (_: Int) + m

  val inc1 = makeIncreaser(1)
  println(inc1(10))
  // 11

  val inc100 = makeIncreaser(100)
  println(inc100(10))
  // 110

  var mm = 1
  val incMm = makeIncreaser(mm)
  println(incMm(10))
  // 11

  mm = 100
  println(incMm(10))
  // 11
  // Closure を生成する関数に渡した変数の値を変えても Closure の結果は変わらない
  // Closure を生成する時に、 mm を束縛しているのではなく m を束縛しているから、ということなのかも知れない
}
