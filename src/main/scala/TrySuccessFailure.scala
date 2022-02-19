import scala.util.{Failure, Success, Try}

object TrySuccessFailure extends App {

  def  makeInt(s: String): Try[Int] = Try(s.trim.toInt)

  val answer = for {
    x <- makeInt("1")
    y <- makeInt("2")
    z <- makeInt("hola")
  } yield x + y + z

  val sum = for {
    x <- makeInt("1")
    y <- makeInt("2")
    z <- makeInt("3")
  } yield x + y + z

  answer match {
    case Success(i) => println(s"the sum is $i")
    case Failure(e) => println(s"Failed, message is: $e")
  }

  sum match {
    case Success(i) => println(s"the sum is $i")
    case Failure(e) => println(s"Failed, message is: $e")
  }

}
