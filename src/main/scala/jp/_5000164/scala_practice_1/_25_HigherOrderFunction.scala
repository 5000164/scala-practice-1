package jp._5000164.scala_practice_1

import java.io.File

/**
  * To learn higher order function.
  *
  * 条件にマッチするものだけに絞り込む時に高階関数を使って重複を削除し
  * コードが短くなることを学ぶ。
  */
object _25_HigherOrderFunction extends App {

  object FileMatcher {
    private def filesHere = new File(".").listFiles

    private def filesMatching(matcher: String => Boolean): Array[File] = {
      for (file <- filesHere; if matcher(file.getName))
        yield file
    }

    def fileEnding(query: String): Array[File] = filesMatching(_.endsWith(query))

    def filesContaining(query: String): Array[File] = filesMatching(_.contains(query))
  }

  FileMatcher.fileEnding(".sbt").foreach(println)
  // ./build.sbt
  FileMatcher.filesContaining("ld.s").foreach(println)
  // ./build.sbt
}
