object ImplicitValue extends App {
  implicit val boo = true

//  ambiguous implicit values: there can only be one implicit value for the scope with the same type
//  implicit val oli = false

//  this one has a different type as the one expected by printIfTrue so there is no conflict
  implicit val olo = 3

  def printIfTrue(a: Int)(implicit b: Boolean) = {
    if(b) println(a)
  }

  printIfTrue(32)
}
