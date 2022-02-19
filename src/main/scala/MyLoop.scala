import scala.annotation.tailrec

object MyLoop extends App {

//  def whilst(condition: => Boolean)(codeBlock: => Unit): Unit = {
//    while(condition) {
//      codeBlock
//    }
//  }

  @tailrec
  def whilst(condition: => Boolean)(codeBlock: => Unit): Unit = {
    condition match {
      case false => ()
      case true =>
        codeBlock
        whilst(condition)(codeBlock)
    }
  }

  var i = 1
  whilst(i <= 5) {
    println(i)
    i += 1
  }

}
