package jp._5000164.scala_practice_1

/**
  * flatMap ついて学ぶため
  *
  * List[Any] を flatten する処理を map と flatMap で書き比べてみる
  */
object _13_FlatMap extends App {
  val list = List(List(List(1, 2), 3), List(4), 5)

  def mapFunction(list: List[Any]): List[Any] = {
    val l: List[List[Any]] = list map {
      case ll: List[_] => ll
      case v => List(v)
    }
    val ll = l.flatten
    if (ll.exists(v => v.isInstanceOf[List[Any]])) mapFunction(ll) else ll
  }

  val map = mapFunction(list)
  println(map)
  // List(1, 2, 3, 4, 5)

  def flatMapFunction(list: List[Any]): List[Any] = list flatMap {
    case l: List[_] => flatMapFunction(l)
    case v => List(v)
  }

  val flatMap = flatMapFunction(list)
  println(flatMap)
  // List(1, 2, 3, 4, 5)
}
