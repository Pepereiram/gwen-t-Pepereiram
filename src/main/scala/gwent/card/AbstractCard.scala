package cl.uchile.dcc
package gwent.card

/** Class that represents a card in the game Gwent */
abstract class AbstractCard(val name: String, val effect: String) extends ICard {
  override def getName: String

  override def getEffect: String
}
