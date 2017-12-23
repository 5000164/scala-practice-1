package jp._5000164.scala_practice_1

import scala.collection.mutable
import scala.compat.Platform

/**
  * WeakHashMap について学ぶ
  *
  * WeakHashMap に値を設定した後にガベージコレクションを実行して結果がどうなるのかを確認する
  */
object _7_WeakHashMap extends App {
  // WeakHashMap を生成してプリミティブ型の変数と参照型の変数をキーとして要素を追加する
  val cache = mutable.WeakHashMap.empty[String, String]
  var key1 = "key1"
  cache += (key1 -> "key1")
  var key2 = new String("key2")
  cache += (key2 -> "key2")
  println(cache)
  // Map(key1 -> key1, key2 -> key2)

  // キーへの強参照があるのでガベージコレクションを実行しても要素が消えないことを確認する
  Platform.collectGarbage
  println(cache)
  // Map(key1 -> key1, key2 -> key2)

  // 挙動の違いを確認するためにプリミティブ型の変数への上書きと参照型の変数への上書きを行う
  // この時点ではまだ WeakHashMap の要素は消えない
  key1 = null
  key2 = null
  println(cache)
  // Map(key1 -> key1, key2 -> key2)

  // 参照型の変数をキーとしていた要素のみが消えていることを確認するためにガベージコレクションを実行する
  Platform.collectGarbage
  println(cache)
  // Map(key1 -> key1)

  // 参照型の変数へ null を代入することで生成されたオブジェクトへの強参照がなくなる
  // キーであるオブジェクトへの強参照がないと判断されてガベージコレクションが実行されたタイミングで要素が削除される
}
