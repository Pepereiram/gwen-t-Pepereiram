package cl.uchile.dcc
package gwent.states

import gwent.GameController

class CPUPlaying (context: GameController) extends GameState(context){
  
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CPUPlaying]
      (this eq other) || (this.context == other.context)
    } else {
      false
    }
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[CPUPlaying]
  }

  /** Transition the game state from [[CPUPlaying]] to [[IdleState]].
   */
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}
