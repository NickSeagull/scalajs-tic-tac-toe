package com.ntchayka.TicTacToe

object Main {
  val p1 = Player('X')
  val p2 = Player('O')
  val initBoard = Board()

  def main(args: Array[String]) {
    val initGame = State(p1, p2, true, initBoard)
    loop(initGame)
  }

  def loop(state: State) {
    cleanScreen
    print(state.board)

    if(!state.finishedGame){
      println("Turn of ")
      if (state.p1Turn == true) println("crosses!\n")
      else println("noughts!\n")
      println("Choose a position!")
      println("Insert X:")
      val x = readInt()
      println("Insert Y:")
      val y = readInt()
      if(x > 2 || x < 0 || y > 2 || y < 0){
        println("Wrong position!")
        Thread.sleep(1000)
        loop(state)
      }
      else if(state.board.positionNotAvailable((x,y))){
        println("Wrong position!")
        Thread.sleep(1000)
        loop(state)
      }
      else{
        val newState = State(state.player1, state.player2, !state.p1Turn, state.move((x,y)))
        loop(newState)
      }
    }
    else{
      println(state.whoWon)
    }

  }

  def cleanScreen {
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
  }
}
