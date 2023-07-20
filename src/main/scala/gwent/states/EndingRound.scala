package cl.uchile.dcc
package gwent.states

import gwent.GameController

class EndingRound (context: GameController) extends GameState(context){
  
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[EndingRound]
      (this eq other) || (this.context == other.context)
    } else {
      false
    }
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[EndingRound]
  }

  /** Transition the game state from [[EndingRound]] to [[WinCondition]].
   */
  override def toWinCondition(): Unit = {
    context.state = new WinCondition(context)
  }
}
