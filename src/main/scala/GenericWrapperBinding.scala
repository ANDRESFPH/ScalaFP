case class Debuggable[A](value: A, message: List[String]) {
  def map[B](f: A => B): Debuggable[B] = Debuggable(f(value), message)

  def flatMap[B](f: A => Debuggable[B]): Debuggable[B] = {
    val res = f(value)
    Debuggable(res.value, message ::: res.message)
  }
}

object GenericWrapperBinding extends App {
  def f(a: Int): Debuggable[Int] = {
    val res = a * 2
    Debuggable(res, List(s"Res is: $res"))
  }

  def g(a: Int): Debuggable[Int] = {
    val res = a * 3
    Debuggable(res, List(s"Res is: $res"))
  }

  def h(a: Int): Debuggable[Int] = {
    val res = a * 4
    Debuggable(res, List(s"Res is: $res"))
  }

  val res: Debuggable[Int] = for {
    fres <- f(100)
    gres <- g(fres)
    hres <- h(gres)
  } yield hres

  println(res)
}
