package jp._5000164.scala_practice_1

/**
  * For について学ぶため
  *
  * 文字列の List から特定の文字列を含む行の文字数を取得する
  */
object _16_For extends App {
  val source = List(
    "test",
    "test test",
    "test test test",
    "a",
    "b",
    "c"
  )

  val result = for {
    line <- source
    trimmed = line.trim
    if trimmed.matches(".*test.*")
  } yield {
    trimmed.length
  }

  println(result)
  // List(4, 9, 14)
}
