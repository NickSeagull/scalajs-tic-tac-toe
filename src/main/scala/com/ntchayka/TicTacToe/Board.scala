package com.ntchayka.TicTacToe

import scala.scalajs.js
import js.annotation.JSExport

@JSExport
object Board {
  val d = '-'
  val o = 'O'
  val x = 'X'

  val winSets = List (
    List(0,1,2),
    List(3,4,5),
    List(6,7,8),
    List(0,3,6),
    List(1,4,7),
    List(2,5,8),
    List(0,4,8),
    List(2,4,6)
  )

  @JSExport
  def apply() = new Board(List(d,d,d,d,d,d,d,d,d))
  @JSExport
  def apply(lst: List[Char]) = new Board(lst)
}

@JSExport
class Board(val state: List[Char]) {
  
  @JSExport
  def putSymbol(symbol: Char, pos: (Int, Int)): Board = {
    val p = pos._1 * 3 + pos._2
    val (fst, snd) = state.splitAt(p)
    Board(fst ++ (symbol :: snd.tail))
  }

  @JSExport
  def finishedGame: Boolean = wonBy('O') || wonBy('X')
  @JSExport
  def wonBy(symbol: Char): Boolean = Board.winSets.exists(winSet => winSet.forall(state(_) == symbol))
  @JSExport
  def positionNotAvailable(pos: (Int,Int)): Boolean = {
    val p = pos._1 * 3 + pos._2
    return (state(p) == 'X' || state(p) == 'O')
  }

  @JSExport
  override def toString = newLineEvery(3, state).mkString

  private def newLineEvery(charNumber: Int,
                           lst: List[Char]): List[Char] = lst match {
    case Nil => List('\n')
    case e   => {
      val (fst, snd) = e.splitAt(3)
      (fst :+ '\n') ++ newLineEvery(charNumber,snd)
    }
  }
}
