package jp._5000164.scala_practice_1

/**
  * To learn how to call method.
  *
  * Try repeated, name, default.
  */
object _22_CallMethod extends App {

  def repeated(s: String*): Unit = s.foreach(println)

  repeated("hello", "world!")
  // hello
  // world!

  repeated(Array("hello", "world!"): _*)
  // hello
  // world!

  def name(one: String, two: String): Unit = {
    println(one)
    println(two)
  }

  name("one", "two")
  // one
  // two

  name(one = "one", two = "two")
  // one
  // two

  name(two = "two", one = "one")
  // one
  // two

  def default(s: String = "default"): Unit = println(s)

  default("d")
  // d

  default()
  // default

  def nameDefault(one: String = "one", two: String = "two"): Unit = {
    println(one)
    println(two)
  }

  nameDefault(two = "2")
  // one
  // 2

  // can not use repeated parameters with default arguments
  // see: https://stackoverflow.com/questions/33809963/why-are-default-arguments-not-allowed-in-a-scala-section-with-repeated-parameter
  // def repeatedDefault(d: String = "default", s: String*): Unit = s.foreach(println)
}
