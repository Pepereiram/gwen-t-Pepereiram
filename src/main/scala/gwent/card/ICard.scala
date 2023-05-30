package cl.uchile.dcc
package gwent.card

import gwent.board.PlayerSide

/** Trait that dictates the general behavior of a Card */
trait ICard {
  /** Method that returns the Card's name */
  val name: String
  val effect: String
  
  def playCard(b: PlayerSide): Unit

}
