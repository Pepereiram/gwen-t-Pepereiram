package cl.uchile.dcc
package gwent

import card.ICard
import board.PlayerSide
import scala.collection.mutable.ListBuffer
/** Trait that dictates the general actions of a Player class */
trait IPlayer {
  protected val _name: String
  protected var _gems: Int
  protected val _deck: ListBuffer[ICard]
  protected val _hand: ListBuffer[ICard]
  
  /** Method the returns the Player's name */
  def name: String
  /** Method that returns the Player's current gems */
  def gems: Int
  /** Method that subtracts the Player's gems by a given value */
  def gems_(value: Int): Unit
  /** Method that plays a Card from the Player's hand*/
  def playCard(card: ICard): Boolean
  /** Method that shuffles the Player's Deck */
  def shuffleDeck: Boolean
  /** Method that draws cards from the Player's deck */
  def drawCards(): Boolean
  /** Method that returns the Player's Hand */
  def hand: ListBuffer[ICard]
  /** Method that returns the Player's Deck */
  def deck: ListBuffer[ICard]
  


}
