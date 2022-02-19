object Binding extends App {

  def f(a: Int): (Int, String) = {
    val res = a * 2
    (res, s"result: $res")
  }

  def g(a: Int): (Int, String) = {
    val res = a * 3
    (res, s"result: $res")
  }

  def h(a: Int): (Int, String) = {
    val res = a * 4
    (res, s"result: $res")
  }

  def bind(f: Int => (Int, String), res: (Int, String)): (Int, String) = {
    val (resInt, resString) = res
    val (newResInt, newResString) = f(resInt)
    (newResInt, resString + newResString)
  }

  val fRes = f(100)
  val gRes = bind(g, fRes)
  val hRes = bind(h, gRes)
  println(hRes)
}
