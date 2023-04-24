package cl.uchile.dcc
package gwent

import card.{AbstractCard, ICard}

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** Class that represents a player in Gwent */
class Player(val name: String, var deck: ListBuffer[ICard]) extends IPlayer with Equals {
  /** Gems are the "HP" in Gwent */
  var gems: Int = 2
  val hand: ListBuffer[ICard] = ListBuffer()

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
      val card: ICard = deck.head
      this.hand.addOne(card)
      deck.remove(0)
      true
    }
  }

  override def shuffleDeck(deck: ListBuffer[ICard]): Boolean = {
    if (deck.nonEmpty) {
      Random.shuffle(deck)
      true
    } else {
      println("Deck is empty")
      false
    }
  }

  override def playCard(card: ICard): Boolean = {
    /* if the card is in hand -> true and play it, if not false */
    if (hand.contains(card) && hand.nonEmpty){
      //Not yet implemented
      hand -= card
      true
    } else{
      println("Card not in hand")
      false
    }
  }
}
