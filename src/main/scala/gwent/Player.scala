package cl.uchile.dcc
package gwent

import card.ICard

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** Class that represents a player in Gwent */
class Player(val name: String, var gems: Int = 2,
             val deck: ListBuffer[ICard], val hand: ListBuffer[ICard] ) extends IPlayer with Equals {

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
  override def drawCards(): Boolean = {
    /* if there are cards in deck -> add to hand and true, if not false */
    if (this.deck.isEmpty){
      false
    } else{
      val card: ICard = this.deck.head
      this.hand += card
      this.deck.remove(0)
      true
    }
  }

  override def getName: String = this.name

  override def getGems: Int = this.gems

  override def setGems(value: Int): Boolean = {
    if (this.gems > 0) {
      this.gems -= value
      true
    } else {
      false
    }
  }

  override def getDeck: ListBuffer[ICard] = this.deck

  override def getHand: ListBuffer[ICard] = this.hand

  override def shuffleDeck: Boolean = {
    if (this.deck.nonEmpty) {
      Random.shuffle(this.deck)
      true
    } else {
      println("Deck is empty")
      false
    }
  }

  override def playCard(card: ICard): Boolean = {
    /* if the card is in hand -> true and play it, if not false */
    if (this.hand.contains(card) && this.hand.nonEmpty){
      //Not yet implemented
      this.hand -= card
      true
    } else{
      println("Card not in hand")
      false
    }
  }
}
