package jp._5000164.scala_practice_1

/**
  * ReduceLeft の使い方を確認する
  *
  * 1, 2, 3 の要素を持つイテレーターの中から最大の数を取得する処理で動作を確認する
  */
object _5_ReduceLeft extends App {
  // reduce は減らす、縮める、切り詰める、下げる、などの意味の英単語
  // reduce メソッドは (おそらく) 要素を減らしてまとめる、というような意味
  // reduceLeft は要素の左から処理を行っていく
  // op( op( ... op(x_1, x_2) ..., x_{n-1}), x_n)

  // reduceLeft にはパラメーターを 2 つ取る関数を引数として渡す
  // パラメーターと関数の結果は同じ型である必要がある
  // 関数リテラルで a, b の 2 つのパラメーターを受け取る関数を表現
  // 各要素の中から最大の数値を探しているので、数値が大きい方を結果として返す
  // 1, 2, 3 という要素を持つイテレーターに対して実際に動作させると次の順番で処理を行う
  // イテレーターの先頭の要素である 1 が a に代入され、 2 番目の要素である 2 が b に代入される、関数の結果として 1 と 2 を比較して大きい方の 2 を返す
  // 前回の関数の結果である 2 が a に代入され、次の要素である 3 が b に代入される、関数の結果として 2 と 3 を比較して大きい方の 3 を返す
  val maxNumber = (1 to 3).reduceLeft(
    (a, b) => if (a > b) a else b
  )
  println(maxNumber) // 3
}
