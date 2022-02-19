package game

import scala.io.StdIn.readLine
import scala.util.Random

object CoinFlipUtil {

  def showPrompt(): Unit = { print("\n(h)eads, (t)ails or (q)uit: ")}

  def getUserInput() = readLine.trim.toUpperCase

  def printableFlipResult(flip: String) = flip match {
    case "H" => "Heads"
    case "T" => "Tails"
  }

  def printGameState(gameState: GameState): Unit = {
    println(s" #Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrectGuesses}")
  }

  def printGameState(printableResult: String, gameState: GameState): Unit = {
    print(s"Flip was $printableResult")
    printGameState(gameState)
  }

  def printGameOver(): Unit = println("=== GAME OVER ===")



  def tossCoin(r: Random) = {
    r.nextInt(2) match {
      case 0 => "H"
      case 1 => "T"
    }
  }

}
