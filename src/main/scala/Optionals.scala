object Optionals extends App {

  def makeInt(s: String): Option[Int] = {
    try {
      Some(s.trim.toInt)
    } catch {
      case _: Exception => None
    }
  }

  makeInt("8") match {
    case Some(i) => println(s"the value is $i")
    case None => println("toInt didn't work with the input")
  }


  val result = for {
    x <- makeInt("1")
    y <- makeInt("2")
    z <- makeInt("3")
  } yield x + y + z

  println(result)

}
