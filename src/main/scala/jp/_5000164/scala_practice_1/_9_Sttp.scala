package jp._5000164.scala_practice_1

import com.softwaremill.sttp._

/**
  * sttp でローカルプロキシーを通して SSL の通信内容を見る
  *
  * 手元で動かしている Charles のプロキシーを通して通信内容を見る
  */
object _9_Sttp extends App {
  // Charles の発行している証明書を信頼する必要がある
  // 実行時に javaOptions で証明書の設定をする必要がある
  // TODO: 実行方法のブログを書いたらリンクを貼る

  implicit val backend = HttpURLConnectionBackend(options = SttpBackendOptions.httpProxy("localhost", 8888))
  sttp
    .get(uri"https://www.google.co.jp/")
    .send()
    .body match {
    case Right(response) => println(response) // Web サイトのコンテンツが表示される
    case Left(error) => println(error) // status が 2xx じゃない場合にエラー内容が表示される
  }
}
