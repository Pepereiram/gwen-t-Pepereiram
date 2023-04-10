package cl.uchile.dcc
package gwent.card

/** Class that represents a card in the game Gwent */
class Card(name: String, effect: Unit) extends ICard {

  override def getName(): String = {
    this.name
  }
}
