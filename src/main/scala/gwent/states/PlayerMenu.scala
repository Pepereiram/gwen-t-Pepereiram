package cl.uchile.dcc
package gwent.states

import gwent.GameController

class PlayerMenu(context: GameController) extends GameState(context){
  /** Transition the game state from [[PlayerMenu]] to [[DrawingCard]].
   */
  override def toDrawingCard(): Unit = {
    context.state = new DrawingCard(context)
  }

  /** Transition the game state from [[PlayerMenu]] to [[PlayingCard]].
   */
  override def toPlayingCard(): Unit = {
    context.state = new PlayingCard(context)
  }

  /** Transition the game state from [[PlayerMenu]] to [[PassingTurn]].
   */
  override def toPassingTurn(): Unit = {
    context.state = new PassingTurn(context)
  }
}
