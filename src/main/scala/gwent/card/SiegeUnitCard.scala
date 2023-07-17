package cl.uchile.dcc
package gwent.card
import gwent.board.PlayerSide

import cl.uchile.dcc.gwent.card.effect.Effect

/** Class that represents a Siege Unit Card in the game Gwent */
class SiegeUnitCard(_name: String, _effect: Effect, _power: Int) extends AbstractUnitCard(_name,_effect,_power) with Equals {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[SiegeUnitCard]
  }
  override def equals(that: Any): Boolean = {
    if (canEqual(that)){
      val other = that.asInstanceOf[SiegeUnitCard]
      (this eq other) || (this.name == other.name && this.effect == other.effect && this.power == other.power)
    } else {
      false
    }
  }

  override def name: String = _name

  override def effect: Effect = _effect

  override def power: Int = _power

  override def power_(newPower: Int): Unit = super.power_(newPower)

  override def playCard(b: PlayerSide): Unit = {
    b.placeSiegeCard(this)
  }
}
