package com.ntchayka.TicTacToe

import scala.scalajs.js
import js.annotation.JSExport
import js.Dynamic.{ global => g }

@JSExport
object ScalaJSTicTacToe {

  val p1 = Player('X')
  val p2 = Player('O')
  val initBoard = Board()
  var state = State(p1, p2, true, initBoard)

  @JSExport
  def canvasClicked(x: Int, y: Int) {
    val canvasId = "canvas" + x + y
    val canvas = g.document.getElementById(canvasId)
    val ctx = canvas.getContext("2d")
    if(!state.board.positionNotAvailable((x, y))){
      if(state.p1Turn){
        ctx.beginPath()
        ctx.moveTo(10, 10)
        ctx.lineTo(90, 90)
        ctx.moveTo(90, 10)
        ctx.lineTo(10, 90)
        ctx.lineWidth = 15
        ctx.stroke()
        ctx.closePath()
        state = State(p1, p2, !state.p1Turn, state.move((x, y)))
      }
      else{
        ctx.beginPath()
        ctx.arc(50, 50, 40, 0, Math.PI * 2, true)
        ctx.lineWidth = 15
        ctx.stroke()
        ctx.closePath()
        state = State(p1, p2, !state.p1Turn, state.move((x, y)))
      }
      checkForWinners
    }
    else{
      g.alert("That space is already occupied, try another one!")
    }
  }

  def checkForWinners{
    if(state.finishedGame){
      g.alert(state.whoWon)
      g.location.reload()
    }
  }

}
