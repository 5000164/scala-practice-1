package jp._5000164.scala_practice_1

object _3_ArrayList extends App {
  // Array クラスのインスタンスを値と型でパラメーター化
  // パラメーター化とは生成するインスタンスの構成を設定すること
  val greetStrings1 = new Array[String](3) // Array クラスを 3 つの要素を持つという値と String という型でパラメーター化
  greetStrings1(0) = "Hello"
  greetStrings1(1) = ", "
  greetStrings1(2) = "world!\n"
  for (i <- 0 to 2)
    print(greetStrings1(i)) // Hello, world!

  // 括弧で囲まれた 1 個以上の引数を伴う変数への代入は update メソッド呼び出しへ変換される
  // 下記のコードは上記と同等
  val greetStrings2 = new Array[String](3)
  greetStrings2.update(0, "Hello")
  greetStrings2.update(1, ", ")
  greetStrings2.update(2, "world!\n")
  for (i <- 0 to 2)
    print(greetStrings2(i)) // Hello, world!

  // Array コンパニオンオブジェクトで定義されている apply というファクトリーメソッドを呼び出して作成することもできる
  // コンパニオンオブジェクトについての詳細は後々やる
  val greetStrings3 = Array.apply("Hello", ", ", "world!\n")
  for (i <- 0 to 2)
    print(greetStrings3(i)) // Hello, world!

  // 括弧で囲んだ 1 つ以上の値を変数に適用したコードは apply メソッド呼び出しへ変換される
  // 下記のコードは上記と同等
  val greetStrings4 = Array("Hello", ", ", "world!\n")
  for (i <- 0 to 2)
    print(greetStrings4(i)) // Hello, world!

  // Array は型と要素数はイミュータブルだが、要素の値はミュータブルである
  val greetStrings5 = Array("Hello", ", ", "world!\n")
  // greetStrings5 = Array("Hello", " again, ", "world!\n") // 再代入不可でエラー
  greetStrings5(1) = " again, "
  for (i <- 0 to 2)
    print(greetStrings5(i)) // Hello again, world!

  // List はイミュータブルなシーケンスである
  // シーケンスとは要素が連続したもののこと
  val greetStrings6 = List("Hello", ", ", "world!\n")
  // greetStrings6 = List("Hello", " again, ", "world!\n") // 再代入不可でエラー
  // greetStrings6(1) = " again, "                         // update メソッドが実装されていないのでエラー
  for (i <- 0 to 2)
    print(greetStrings6(i)) // Hello, world!
}
