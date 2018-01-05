package jp._5000164.scala_practice_1

/**
  * flatMap ついて学ぶため
  */
object _13_FlatMap extends App {
  val list = List(List(List(1, 2), 3), List(4), 5)

  def mapFunction(list: List[Any]): List[Any] = {
    def mapR(l: List[Any]): List[Any] = l map {
      case ll: List[_] => mapR(ll)
      case v => List(v)
    }

    val wrap = mapR(list)
    println(wrap)
    wrap
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
