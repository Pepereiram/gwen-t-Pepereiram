package cl.uchile.dcc
package gwent.states

import gwent.GameController

class PassingTurn (context: GameController) extends GameState(context){
  /** Transition the game state from [[PassingTurn]] to [[IdleState]].
   */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[PassingTurn]
      (this eq other) || (this.context == other.context)
    } else {
      false
    }
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[PassingTurn]
  }
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}
