package cl.uchile.dcc
package gwent

/** Class that represents a player in Gwent */
class Player(val name: String) extends IPlayer {
  /** Gems are the "HP" in Gwent */
  var gems: Int = 2
  //var deck: Array[String]
  //var hand: Array[String]
  /*var deck: Array[Card] = null*/
  /*var hand: Array[Card] = null*/
  override def equals(obj: Any): Boolean = super.equals(obj)

  override def getName(): String = {
    this.name
  }

  override def getGems(): Int = {
    this.gems
  }

  override def drawCards(): Boolean = {
    /* if there are cards in deck -> add to hand and true, if not false */
    false
  }

  override def playCard(): Boolean = {
    /* if the card is in hand -> true and play it, if not false */
    false
  }
}
