package com.ntchayka.TicTacToe

import scala.scalajs.js
import js.annotation.JSExport
@JSExport
object State{
  @JSExport
  def apply(p1: Player, p2: Player, p1T: Boolean, b:Board) = new State(p1, p2, p1T, b)
}
@JSExport
class State(val player1: Player, val player2: Player, val p1Turn: Boolean, val board: Board) {

  @JSExport
  def move(pos: (Int, Int)): Board = {
    if (p1Turn) board.putSymbol(player1.symbol, pos)
    else board.putSymbol(player2.symbol, pos)
  }

  @JSExport
  def finishedGame: Boolean = board.finishedGame

  @JSExport
  def whoWon: String = {
    if (board.wonBy('X')) "Crosses win!"
    else if (board.wonBy('O')) "Noughts win!"
    else "No one has won yet!"
  }

}
