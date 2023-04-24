package cl.uchile.dcc
package gwent

import card.ICard

import scala.collection.mutable.ListBuffer
/** Trait that dictates the general actions of a Player class */
trait IPlayer {
  val name: String
  /** Method that plays a Card */
  def playCard(card: ICard): Boolean
  /** Method that shuffles the Player's Deck */
  def shuffleDeck(deck: ListBuffer[ICard]): Boolean
  /** Method that draws cards from the Player's deck */
  def drawCards(): Boolean

}
