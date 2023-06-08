package cl.uchile.dcc
package gwent.states

import gwent.GameController

class WinCondition (context: GameController) extends GameState(context){
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }

  override def toGameEnd(): Unit = {
    context.state = new GameEnd(context)
  }
}
