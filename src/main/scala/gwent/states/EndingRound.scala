package cl.uchile.dcc
package gwent.states

import gwent.GameController

class EndingRound (context: GameController) extends GameState(context){
  /** Transition the game state from [[EndingRound]] to [[WinCondition]].
   */
  override def toWinCondition(): Unit = {
    context.state = new WinCondition(context)
  }
}
