package jp._5000164.scala_practice_1

/**
  * 不要なキーを持たない Map を生成する方法を学ぶため。
  *
  * Option の値を受け取って、 Some の時だけ Map にセットして
  * None だった場合はキーすらも Map に生成しないようにする。
  */
object _23_Map extends App {
  def createIf(id: String, email: Option[String] = None, tel: Option[String] = None) =
    Map(
      "id" -> id
    ) ++ (if (email.isDefined)
      Map("email" -> email.get)
    else Map()) ++ (if (tel.isDefined)
      Map("tel" -> tel.get)
    else Map())

  println(createIf("user_id", Some("email"), Some("tel")))
  // Map(id -> user_id, email -> email, tel -> tel)
  println(createIf("user_id", None, Some("tel")))
  // Map(id -> user_id, tel -> tel)
  println(createIf("user_id", Some("email"), None))
  // Map(id -> user_id, email -> email)

  def createMap(id: String, email: Option[String] = None, tel: Option[String] = None) = {
    def optionToMap(values: Map[String, Option[String]]): Map[String, String] =
      values.filter(_._2.isDefined).map {
        case (k, v) => (k, v.get)
      }

    Map(
      "id" -> id
    ) ++ optionToMap(Map(
      "email" -> email,
      "tel" -> tel
    ))
  }

  println(createMap("user_id", Some("email"), Some("tel")))
  // Map(id -> user_id, email -> email, tel -> tel)
  println(createMap("user_id", None, Some("tel")))
  // Map(id -> user_id, tel -> tel)
  println(createMap("user_id", Some("email"), None))
  // Map(id -> user_id, email -> email)
}
