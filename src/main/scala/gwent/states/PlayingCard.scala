package cl.uchile.dcc
package gwent.states

import gwent.GameController

class PlayingCard (context: GameController) extends GameState(context){
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[PlayingCard]
      (this eq other) || (this.context == other.context)
    } else {
      false
    }
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[PlayingCard]
  }
  /** Transition the game state from [[PlayingCard]] to [[IdleState]].
   */
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}
