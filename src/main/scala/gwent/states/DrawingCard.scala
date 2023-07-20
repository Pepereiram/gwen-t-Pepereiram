package cl.uchile.dcc
package gwent.states

import gwent.GameController

class DrawingCard (context: GameController) extends GameState(context){
  
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[DrawingCard]
      (this eq other) || (this.context == other.context)
    } else {
      false
    }
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[DrawingCard]
  }

  /** Transition the game state from [[DrawingCard]] to [[PlayerMenu]].
   */
  override def toPlayerMenu(): Unit = {
    context.state = new PlayerMenu(context)
  }
}
