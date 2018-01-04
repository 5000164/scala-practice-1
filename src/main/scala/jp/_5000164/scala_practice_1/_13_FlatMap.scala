package jp._5000164.scala_practice_1

/**
  * flatMap ついて学ぶため
  */
object _13_FlatMap extends App {
  val list = List(List(List(1, 2), 3), List(4), 5)
  println(list)

  def mapFunction(list: List[Any]): List[Any] = list map {
    case l: List[_] => mapFunction(l)
    case v => v
  }

  val map = mapFunction(list)
  println(map)

  def flatMapFunction(list: List[Any]): List[Any] = list flatMap {
    case l: List[_] => flatMapFunction(l)
    case v => List(v)
  }

  val flatMap = flatMapFunction(list)
  println(flatMap)
}
