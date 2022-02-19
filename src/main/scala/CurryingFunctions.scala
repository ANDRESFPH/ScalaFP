object CurryingFunctions extends App {

  def add(a: Int, b: Int): Int = a + b

  val addCurried = (add _).curried

//  no need to add the last argument like (_)
  val plusTwo = addCurried(2)

  def plusTwoCurried = addCurried(2)

  println(plusTwo(3))
  println(plusTwoCurried(10))
}
