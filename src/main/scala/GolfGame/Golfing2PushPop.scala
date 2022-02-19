package GolfGame

object Golfing2PushPop extends App {
  def push[A](xs: List[A], a: A): List[A] = a :: xs

  def pop[A](xs: List[A]): (A, List[A]) = (xs.head, xs.tail)


  val s0: List[Int] = Nil
  val s1 = push(s0, 20)
  val s2 = push(s1, 15)
  val s3 = push(s2, 0)

  val (swing3, state2) = pop(s3)
  println(s"swing3 = $swing3")
  println(s"state2 = $state2")
//  println(s3)


}
