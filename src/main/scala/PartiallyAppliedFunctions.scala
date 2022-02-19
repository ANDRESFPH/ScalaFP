object PartiallyAppliedFunctions extends App {
  def sum(a: Int)(b: Int): Int = a + b

  def plusTwo = sum(2)(_)


  def greeting = wrapString("Hello")(_: String)("nice to meet you")

  println(plusTwo(3))
  println(greeting("Andres"))

  def andresGoodBye = wrapString("Goodbye")("Andres")(_)

  println(andresGoodBye("I love you"))


  def wrap(prefix: String, message: String, sufix: String): String = {
    s"$prefix $message $sufix"
  }

  def wrapPartially = wrap("Hello", _: String, "nice to meet you")

  println(wrapPartially("Felipe"))


  def wrapString(prefix: String)(message: String)(sufix: String): String = {
    s"$prefix $message $sufix"
  }

  def twoEmptyParams = wrapString("Hello")(_: String)(_: String)

  println(twoEmptyParams("Andres", "I want you in my bed"))

}
