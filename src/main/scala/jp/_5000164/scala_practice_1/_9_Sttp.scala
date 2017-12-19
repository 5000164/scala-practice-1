package jp._5000164.scala_practice_1

import com.softwaremill.sttp._

/**
  * sttp でローカルプロキシーを通して SSL の通信内容を見る
  *
  * 手元で動かしている Charles のプロキシーを通して通信内容を見る
  */
object _9_Sttp extends App {
  // TODO: Charles の証明書を読み込んでから実行するようにする

  implicit val backend = HttpURLConnectionBackend(options = SttpBackendOptions.httpProxy("localhost", 8888))
  val temp = sttp
    .get(uri"https://www.google.co.jp/")
    .send()
    .body

  println(temp)
}
