package cl.uchile.dcc
package gwent.states

import gwent.GameController

class CPUPlaying (context: GameController) extends GameState(context){
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}
