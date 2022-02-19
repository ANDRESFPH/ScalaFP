import scala.annotation.tailrec

object MyFilterFunction extends App {

  @tailrec
  def filter[A](f: (A) => Boolean, list: Seq[A], nl: Seq[A] = Seq()): Seq[A] = {
    list match {
      case Nil => nl
      case head::tail =>
        filter(f, tail, if(f(head)) nl :+ head else nl)
    }
  }

  val f = (x: Int) => x % 2 == 0
  val res = filter(f, List(0,1,2,3,4,5,6,7,8,9))
  println(res)
}
