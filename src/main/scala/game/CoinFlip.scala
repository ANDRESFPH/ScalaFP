package game

import scala.util.Random
import CoinFlipUtil._

import scala.annotation.tailrec

case class GameState(numFlips: Int, numCorrectGuesses: Int)

object CoinFlip extends App {
  val s = GameState(0, 0)
  val r = Random

  mainLoop(s, r)

  @tailrec
  def mainLoop(gameState: GameState, random: Random): Unit = {
    showPrompt()
    val input = getUserInput()

    input match {
      case "T" | "H" =>
        val result = tossCoin(random)
        val correctGuess = gameState.numCorrectGuesses
        val newCorrectGuess = if(input == result) correctGuess + 1 else correctGuess
        val newGameState = gameState.copy(gameState.numFlips + 1, newCorrectGuess)
        printGameState(printableFlipResult(result), newGameState)
        mainLoop(newGameState, random)
      case _ =>
        printGameOver()
        printGameState(gameState)
    }
  }

}
