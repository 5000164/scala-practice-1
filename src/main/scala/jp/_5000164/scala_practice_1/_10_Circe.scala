package jp._5000164.scala_practice_1

import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

/**
  * circe の使い方について学ぶ
  *
  * https://github.com/circe/circe
  * シンプルな定義と JSON で相互変換を行って動作を確認する
  */
object _10_Circe extends App {
  // 型の定義を行う
  case class User(id: Int, name: String)

  // インスタンスを JSON に変換する
  val taro = User(1, "taro")
  println(taro.asJson.noSpaces)
  // {"id":1,"name":"taro"}

  // JSON をインスタンスに変換する
  val encodedTaro = """{"id":1,"name":"taro"}"""
  println(decode[User](encodedTaro))
  // Right(User(1,taro))

  // 特定の trait を mixin して異なる要素を持つ定義を行う
  sealed trait Base
  case class A(a: String) extends Base
  case class B(b: List[Int], c: User) extends Base

  // そのままインスタンスを生成するとそのままの JSON が生成される
  val a = A("a")
  println(a.asJson.noSpaces)
  // {"a":"a"}
  val b = B(List(1,2,3), User(1, "taro"))
  println(b.asJson.noSpaces)
  // {"b":[1,2,3],"c":{"id":1,"name":"taro"}}

  // 型を mixin 元にすることで型情報が JSON に含まれる
  val baseA: Base = A("a")
  println(baseA.asJson.noSpaces)
  // {"A":{"a":"a"}}
  val baseB: Base = B(List(1,2,3), User(1, "taro"))
  println(baseB.asJson.noSpaces)
  // {"B":{"b":[1,2,3],"c":{"id":1,"name":"taro"}}}

  // 型情報を持っていない JSON だと直接の型を decode 時に指定することで変換できる
  val encodedA = """{"a":"a"}"""
  println(decode[A](encodedA))
  // Right(A(a))
  val encodedB ="""{"b":[1,2,3],"c":{"id":1,"name":"taro"}}"""
  println(decode[B](encodedB))
  // Right(B(List(1, 2, 3),User(1,taro)))

  // 型情報を持っている JSON だと mixin 元の型を指定することで変換できる
  val encodedAWithType = """{"A":{"a":"a"}}"""
  println(decode[Base](encodedAWithType))
  // Right(A(a))
  val encodedBWithType ="""{"B":{"b":[1,2,3],"c":{"id":1,"name":"taro"}}}"""
  println(decode[Base](encodedBWithType))
  // Right(B(List(1, 2, 3),User(1,taro)))

  // 型情報を持っていない JSON は mixin 元の型を指定しても変換できない
  println(decode[Base](encodedA))
  // Left(DecodingFailure(CNil, List()))
}
