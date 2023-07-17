package cl.uchile.dcc
package gwent.states

import gwent.GameController

class IdleState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[IdleState]] to [[CPUPlaying]].
   */
  override def toCPUPlaying(): Unit = {
    context.state = new CPUPlaying(context)
  }

  /** Transition the game state from [[IdleState]] to [[PlayerMenu]].
   */
  override def toPlayerMenu(): Unit = {
    context.state = new PlayerMenu(context)
  }

  /** Transition the game state from [[IdleState]] to [[EndingRound]].
   */
  override def toEndingRound(): Unit = {
    context.state = new EndingRound(context)
  }
}
