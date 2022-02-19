class Wrapper[A] private (value: A) {
  def map[B](f: A => B): Wrapper[B] = {
    val res = f(value)
    new Wrapper(res)
  }

  def flatMap[B](f: A => Wrapper[B]): Wrapper[B] = f(value)

  override def toString = value.toString
}

// companion object has to have the same name as class
object Wrapper {
  def apply[A](value: A): Wrapper[A] = new Wrapper(value)
}

case class Debuggabler(value: Int, message: String) {
  def map(f: Int => Int): Debuggabler = Debuggabler(f(value), message)

  def flatMap(f: Int => Debuggabler): Debuggabler = {
    val res = f(value)
    Debuggabler(res.value, message + res.message)
  }
}

object IntWrapperBinding extends App {
  val result: Wrapper[Int] = for {
    a <- Wrapper(1)
    b <- Wrapper(2)
    c <- Wrapper(1)
  } yield a + b + c

//  println(result)

  def f(a: Int): Debuggabler = {
    val res = a * 2
    Debuggabler(res, s"Res is: $res")
  }
  def g(a: Int): Debuggabler = {
    val res = a * 3
    Debuggabler(res, s"Res is: $res")
  }
  def h(a: Int): Debuggabler = {
    val res = a * 4
    Debuggabler(res, s"Res is: $res")
  }


  val res: Debuggabler = for {
    fres <- f(100)
    gres <- g(fres)
    hres <- h(gres)
  } yield hres

  val fres1: Debuggabler = f(100)
  fres1.flatMap((res1) => (g(res1).flatMap((gres) => h(gres).map((hres) => hres))))

  println(res)
}
