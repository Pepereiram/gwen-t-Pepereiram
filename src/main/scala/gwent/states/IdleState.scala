package cl.uchile.dcc
package gwent.states

import gwent.GameController

class IdleState(context: GameController) extends GameState(context) {
  override def toCPUPlaying(): Unit = {
    context.state = new CPUPlaying(context)
  }

  override def toPlayerMenu(): Unit = {
    context.state = new PlayerMenu(context)
  }

  override def toEndingRound(): Unit = {
    context.state = new EndingRound(context)
  }
}
