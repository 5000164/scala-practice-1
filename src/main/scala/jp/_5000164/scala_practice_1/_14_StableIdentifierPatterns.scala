package jp._5000164.scala_practice_1

/**
  * 安定識別子 (Stable Identifier Patterns) について学ぶため
  *
  * match させてみて動作を確認する
  */
object _14_StableIdentifierPatterns extends App {
  val x = "x"
  val y = "y"
  val X = "x"

  // 文字列で match させる
  "x" match {
    // "x" と "x" を比較しているのでこの case が match する
    case "x" => println("match to x")
    case "y" => println("match to y")
  }
  // match to x

  // 変数で match させる
  // see: https://www.scala-lang.org/files/archive/spec/2.11/08-pattern-matching.html#variable-patterns
  "x" match {
    // 任意の値に一致して、 y にその値をバインドするという意味になる
    case y => println(s"variable y value is $y")
  }
  // variable y value is x

  // 安定識別子で match させる
  // see: https://www.scala-lang.org/files/archive/spec/2.11/08-pattern-matching.html#stable-identifier-patterns
  "x" match {
    // ` で括ることによって安定識別子と判断され、変数 x の内容で match するかどうかを判定する
    case `x` => println("match to x")
    // なので、さっき case y では match していたが、 case `y` では変数の内容が一致しないので match しない
    case `y` => println("match to y")
  }
  // match to x

  // 大文字で始まる変数も安定識別子と判断される
  "x" match {
    case X => println("match to X")
  }
  // match to X
}
