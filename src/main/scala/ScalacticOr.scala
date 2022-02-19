import org.scalactic.{Bad, ErrorMessage, Good, Or}

import java.lang.Thread.sleep
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object ScalacticOr extends App {

  def makeInt(s: String): Int Or ErrorMessage = {
    try {
      Good(s.trim.toInt)
    } catch {
      case e: Exception => Bad(e.toString)
    }
  }

  println(makeInt("3"))
  println(makeInt("hola"))

  val sum = for {
    x <- makeInt("1")
    y <- makeInt("5")
    z <- makeInt("5")
  } yield x + y + z

  sum match {
    case Good(v) => println(s"The sum is $v")
    case Bad(e) => println(s"Failed, message is: $e")
  }

  val err = for {
    x <- makeInt("1")
    y <- makeInt("5")
    z <- makeInt("gsgsfd")
  } yield x + y + z

  err match {
    case Good(v) => println(s"The sum is $v")
    case Bad(e) => println(s"Failed, message is: $e")
  }

  implicit val e = ExecutionContext.global
  val f1 = Future { sleep(10*1000); 1 }
  val f2 = Future { sleep(2*1000); 2 }
  val f3 = Future { sleep(4*1000); 3 }

  val result = for {
    r1 <- f1
    r2 <- f2
    r3 <- f3
  } yield r1 + r2 + r3

  result.onComplete {
    case Success(x) => println(s"the result is: $x")
    case Failure(e) => e.printStackTrace
  }


}
