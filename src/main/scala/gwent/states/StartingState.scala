package cl.uchile.dcc
package gwent.states

import gwent.GameController

class StartingState(context:GameController) extends GameState(context) {
  /** Transition the game state from [[StartingState]] to [[IdleState]].
   */
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}
