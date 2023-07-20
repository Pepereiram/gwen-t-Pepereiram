package cl.uchile.dcc
package gwent.states

import gwent.GameController

class GameEnd (context: GameController) extends GameState(context){
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[GameEnd]
      (this eq other) || (this.context == other.context)
    } else {
      false
    }
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[GameEnd]
  }
}
