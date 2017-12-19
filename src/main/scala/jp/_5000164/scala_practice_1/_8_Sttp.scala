package jp._5000164.scala_practice_1

import com.softwaremill.sttp._

/**
  * sttp の使い方について学ぶ
  *
  * https://github.com/softwaremill/sttp
  * シンプルな方法で Web サイトの情報を取得してみる
  */
object _8_Sttp extends App {
  implicit val backend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()
  sttp
    .get(uri"http://blog.5000164.jp/")
    .send()
    .body match {
    case Right(response) => println(response) // Web サイトのコンテンツが表示される
    case Left(error) => println(error) // status が 2xx じゃない場合にエラー内容が表示される
  }
}
