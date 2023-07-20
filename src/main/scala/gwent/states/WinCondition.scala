package cl.uchile.dcc
package gwent.states

import gwent.GameController

class WinCondition (context: GameController) extends GameState(context){
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WinCondition]
      (this eq other) || (this.context == other.context)
    } else {
      false
    }
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[WinCondition]
  }
  /** Transition the game state from [[WinCondition]] to [[IdleState]].
   */
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }

  /** Transition the game state from [[PlayerMenu]] to [[GameEnd]].
   */
  override def toGameEnd(): Unit = {
    context.state = new GameEnd(context)
  }
}
