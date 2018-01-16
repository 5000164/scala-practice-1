package jp._5000164.scala_practice_1

import java.io.PrintStream

/**
  * To learn output method.
  *
  * Print to standard output, error standard output.
  */
object _21_PrintStream extends App {

  def echo(out: PrintStream, s: String): Unit = out.println(s)

  echo(Console.out, "Console.out")
  // Console.out
  // 標準出力に出る

  echo(Console.err, "Console.err")
  // Console.err
  // 標準エラー出力に出る
}
