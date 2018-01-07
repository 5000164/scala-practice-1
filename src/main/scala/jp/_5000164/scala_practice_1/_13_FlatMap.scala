package jp._5000164.scala_practice_1

/**
  * flatMap ついて学ぶため
  *
  * List[Any] を flatten する処理を map と flatMap で書き比べてみる
  */
object _13_FlatMap extends App {
  val list = List(List(List(1, 2), 3), List(4), 5)

  def mapFunction(list: List[Any]): List[Any] = {
    println("mapFunction 呼び出し")
    println(list)
    val l = list map {
      case l: List[_] => mapFunction(l)
      case v => List(v)
    }
    println("List でラップ後")
    println(l)
    val ll = l.flatten
    println("flatten 後")
    println(ll)
    ll
  }

  val map = mapFunction(list)
  println("結果")
  println(map)

  def flatMapFunction(list: List[Any]): List[Any] = {
    println("flatMapFunction")
    println(list)
    val l = list flatMap {
      case l: List[_] => flatMapFunction(l)
      case v => List(v)
    }
    println("List でラップして flatten 後")
    println(l)
    l
  }

  val flatMap = flatMapFunction(list)
  println("結果")
  println(flatMap)
}
