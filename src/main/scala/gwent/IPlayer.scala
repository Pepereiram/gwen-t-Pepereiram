package cl.uchile.dcc
package gwent

import card.ICard

import scala.collection.mutable.ListBuffer
/** Trait that dictates the general actions of a Player class */
trait IPlayer {
  val name: String
  var deck: ListBuffer[ICard]
  /** Method that plays a Card */
  def playCard(card: ICard): Boolean
  /** Method that shuffles the Player's Deck */
  def shuffleDeck: Boolean
  /** Method that draws cards from the Player's deck */
  def drawCards(): Boolean
  /** Method that returns the Hand of the Player */
  def getHand: ListBuffer[ICard]
  /** Method that returns the Deck of the Player */
  def getDeck: ListBuffer[ICard]
  /** Method that returns the name of the Player */
  def getName: String
  /** Method that returns the current gems of the Player */
  def getGems: Int
  /** Method that returns True if the Player can lose the given gems or false if not*/
  def setGems(value: Int): Boolean

}
