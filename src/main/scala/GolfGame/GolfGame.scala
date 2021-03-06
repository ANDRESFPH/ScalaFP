package GolfGame

object GolfGame extends App {
  case class GolfState(strokes: List[Int])

  def nextStroke(previousState: GolfState, distanceOfHit: Int): GolfState = {
    GolfState(distanceOfHit :: previousState.strokes)
  }

  val state0 = GolfState(Nil)
  val state1 = nextStroke(state0, 20)
  val state2 = nextStroke(state1, 15)
  val state3 = nextStroke(state2, 0)

  println(state3)

}
