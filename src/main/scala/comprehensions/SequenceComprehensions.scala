package comprehensions

import scala.collection.mutable.ArrayBuffer

case class Sequence[A](initialElems: A*) {
  private val elems = ArrayBuffer[A]()

  elems ++= initialElems

  def map[B](f: A => B): Sequence[B] = {
    val abMap: ArrayBuffer[B] = elems.map(f)
    Sequence(abMap.toSeq: _*)
  }

  private def flattenLike[B](seqOfSeq: Sequence[Sequence[B]]): Sequence[B] = {
    val xs: ArrayBuffer[B] = ArrayBuffer()
    for(listB <- seqOfSeq){
      for(e <- listB){
        xs += e
      }
    }
    Sequence(xs.toSeq: _*)
  }

  def flatMap[B](f: A => Sequence[B]): Sequence[B] = {
    val mapRes: Sequence[Sequence[B]] = map(f)   //map
    flattenLike(mapRes)                              //flatten
  }

  def withFilter(p: A => Boolean): Sequence[A] = {
    val tmpArray = elems.filter(p)
    Sequence(tmpArray.toSeq: _*)
  }

  def foreach(block: A => Unit): Unit = {
    def insideLoop(block: A => Unit, elements: ArrayBuffer[A]): Unit = {
      elements.size match {
        case 0 => ()
        case _ =>
          block(elements.head)
          insideLoop(block, elements.tail)
      }
    }

    insideLoop(block, elems)
  }


}

case class Human(name: String)

object SequenceComprehensions extends App {

  val ints = Sequence(1,2,3,4)

//  for(i <- ints) println(i)

//  for {
//    i <- ints
//    if i > 2
//  } yield println(i * 2)

  val myFriends = Sequence(
    Human("Adam"),
    Human("Allan"),
    Human("Andres")
  )

  val adamsFriends = Sequence(
    Human("Killer Bee"),
    Human("Itachi"),
    Human("Andres")
  )

  val mutualFriends = for {
    myFriend <- myFriends
    adamsFriend <- adamsFriends
    if (myFriend.name == adamsFriend.name)
  } yield myFriend

  println(mutualFriends)
}
