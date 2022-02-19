object EitherLerftOrRight extends App {

  def makeInt(s: String): Either[String, Int] = {
    try{
      Right(s.trim.toInt)
    } catch {
      case e: Exception => Left(e.toString)
    }
  }

  println(makeInt("1"))
  println(makeInt("Hola"))

  val err = for {
    x <- makeInt("1")
    y <- makeInt("2")
    z <- makeInt("holi")
  } yield x + y + z


  println(err)

  val sum = for{
    x <- makeInt("1")
    y <- makeInt("2")
    z <- makeInt("5")
  } yield x + y + z

  println(sum)

  sum match {
    case Right(v) => println(s"The sum is: $v")
    case Left(e) => println(s"Failed, message is: $e")
  }

  err match {
    case Right(v) => println(s"The sum is: $v")
    case Left(e) => println(s"Failed, message is: $e")
  }

}
