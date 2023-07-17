package cl.uchile.dcc
package gwent.card

import gwent.board.PlayerSide

/** Trait that dictates the general behavior of a Card */
trait ICard {
  /** Method that returns the Card's name */
  protected val _name: String
  protected val _effect: Effect
  /** Method that returns the Card's name */
  def name: String = _name
  /** Method that returns the Card's effect */
  def effect: Effect = _effect
  /** Method that plays a Card in a given PlayerSide */
  def playCard(b: PlayerSide): Unit

}
