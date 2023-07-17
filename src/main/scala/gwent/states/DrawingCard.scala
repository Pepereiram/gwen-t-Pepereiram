package cl.uchile.dcc
package gwent.states

import gwent.GameController

class DrawingCard (context: GameController) extends GameState(context){
  /** Transition the game state from [[DrawingCard]] to [[PlayerMenu]].
   */
  override def toPlayerMenu(): Unit = {
    context.state = new PlayerMenu(context)
  }
}
