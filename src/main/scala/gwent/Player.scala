package cl.uchile.dcc
package gwent

import card.ICard

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** Class that represents a player in Gwent
 *
 * The player could be user controlled or CPU controlled.
 *
 * @constructor Create a new Player in the game.
 * @param _name the Player's name.
 * @param _gems the Player's current gems.
 * @param _deck the Player's current deck.
 * @param _hand the Player's current hand.
 *
 * @author Jose Pereira Morgado
 * @version 1.2
 * @since 1.0
 */
class Player(val _name: String,
             val _deck: ListBuffer[ICard], val _hand: ListBuffer[ICard],
             var _gems: Int = 2) extends IPlayer with Equals {

  override def equals(that: Any): Boolean = {
    if(canEqual(that)){
      val other = that.asInstanceOf[Player]
      (this eq other) || (this.name == other.name && this.deck == other.deck && this.hand == other.hand)
    } else {
      false
    }
  }
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Player]
  }
  override def name: String = _name
  override def gems: Int = _gems
  override def gems_(value: Int): Unit = {
    if (this._gems > 0) {
      this._gems -= value
    }
  }
  override def deck: ListBuffer[ICard] = _deck
  override def hand: ListBuffer[ICard] = _hand
  override def shuffleDeck: Boolean = {
    if (this._deck.nonEmpty) {
      Random.shuffle(this._deck)
      true
    } else {
      println("Deck is empty")
      false
    }
  }
  override def playCard(card: ICard): Boolean = {
    /* if the card is in hand -> true and play it, if not false */
    if (this._hand.contains(card) && this._hand.nonEmpty){
      //Not yet implemented
      this._hand -= card
      true
    } else{
      println("Card not in hand")
      false
    }
  }
  override def drawCard(): Boolean = {
    /* if there are cards in deck -> add to hand and true, if not false */
    if (this._deck.isEmpty) {
      false
    } else {
      val card: ICard = this._deck.head
      this._hand += card
      this._deck -= card
      true
    }
  }
}
