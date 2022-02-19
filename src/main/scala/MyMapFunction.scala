import scala.annotation.tailrec

object MyMapFunction extends App {

//  def map[A, B](f: A => B, l: Seq[A]): Seq[B] = {
//    for { x <- l } yield f(x)
//  }

  @tailrec
  def map[A, B](f: A => B, l: Seq[A],nl: Seq[B] = Seq()): Seq[B] = {
    l match {
      case Nil => nl
      case head::tail => map(f, tail, nl :+ f(head))
    }
  }

  val l = List(1,2,3)
  val f = (x: Int) => x * 2

  val res = map(f, l)
  println(res)
}
