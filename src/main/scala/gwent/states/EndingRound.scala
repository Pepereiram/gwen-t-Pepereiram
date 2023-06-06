package cl.uchile.dcc
package gwent.states

import gwent.GameController

class EndingRound (context: GameController) extends GameState(context){
  override def toWinCondition(): Unit = {
    context.state = new WinCondition(context)
  }
}
