package com.ntchayka.TicTacToe

import scala.scalajs.js
import js.annotation.JSExport

@JSExport
object Player{
  @JSExport
  def apply(symbol: Char) = new Player(symbol)
}
@JSExport
class Player(val symbol: Char){
  @JSExport
  def makeMove(board:Board, pos: (Int, Int)): Board = board.putSymbol(symbol, pos)
}
