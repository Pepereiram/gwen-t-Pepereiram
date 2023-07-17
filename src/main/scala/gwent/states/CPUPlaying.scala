package cl.uchile.dcc
package gwent.states

import gwent.GameController

class CPUPlaying (context: GameController) extends GameState(context){
  /** Transition the game state from [[CPUPlaying]] to [[IdleState]].
   */
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}
