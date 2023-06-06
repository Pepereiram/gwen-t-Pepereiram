package cl.uchile.dcc
package gwent.states

import gwent.GameController

class DrawingCard (context: GameController) extends GameState(context){
  override def toPlayerMenu(): Unit = {
    context.state = new PlayerMenu(context)
  }
}
