package comprehensions

case class Person(firstName: String, lastName: String)

object ForComprehensions extends App {

  val people = List(
    Person("barney", "rubble"),
    Person("baboso", "rubble"),
    Person("babitas", "rubble"),
    Person("bizcocho", "rubble"),
    Person("fred", "nutella")
  )

  val namesStartingWithB = for {
    p <- people
    fName = p.firstName
    if(fName startsWith "b")
  } yield fName.toUpperCase

  println(namesStartingWithB)

}
