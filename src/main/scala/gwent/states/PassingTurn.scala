package cl.uchile.dcc
package gwent.states

import gwent.GameController

class PassingTurn (context: GameController) extends GameState(context){
  /** Transition the game state from [[PassingTurn]] to [[IdleState]].
   */
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}
