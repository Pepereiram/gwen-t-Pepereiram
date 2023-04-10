package cl.uchile.dcc
package gwent.player

/** Trait that dictates the general actions of a Player class */
trait IPlayer {
  /** Method that returns the Player's name */
  def getName(): String

  /** Method that plays a Card */
  def playCard(): Boolean

  /** Method that draws cards from a Player's deck */
  def drawCards(): Boolean

}
