package jp._5000164.scala_practice_1

/**
  * Option の List から Some の中身のリストを生成する方法を調べるため
  */
object _29_FilterSomeFromList extends App {
  val list = List(Some(1), Some(2), None, Some(4))
  println(list.filter(_.isDefined).map(_.get))
  // List(1, 2, 4)
  println(list.flatten)
  // List(1, 2, 4)

  // 参考
  // http://ym.hatenadiary.jp/entry/2016/03/30/092337
  // https://qiita.com/mtoyoshi/items/b6ce3e12698765057ac7
  // https://github.com/scala/scala/blob/v2.12.4/src/library/scala/Option.scala#L300-L301
}
