package cl.uchile.dcc
package gwent.states

import gwent.GameController

class PlayerMenu(context: GameController) extends GameState(context){
  override def toDrawingCard(): Unit = {
    context.state = new DrawingCard(context)
  }

  override def toPlayingCard(): Unit = {
    context.state = new PlayingCard(context)
  }

  override def toPassingTurn(): Unit = {
    context.state = new PassingTurn(context)
  }
}
