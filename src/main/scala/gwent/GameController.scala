package cl.uchile.dcc
package gwent

import gwent.IPlayer
import gwent.board.PlayerSide
import gwent.card.ICard
import gwent.states.{GameState, IdleState, StartingState}

/** Controller from the videogame Gwen't
 *  This implementation considers a game between a CPU-Player and a Human-Player
 *  */
class GameController {
  var state: GameState = new StartingState(this)

}
