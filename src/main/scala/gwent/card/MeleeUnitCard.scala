package cl.uchile.dcc
package gwent.card
import gwent.board.PlayerSide

/** Class that represents a Melee Unit Card in the game Gwent */
class MeleeUnitCard(_name: String, _effect: String, _power: Int) extends AbstractUnitCard(_name, _effect, _power) with Equals {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[MeleeUnitCard]
  }
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[MeleeUnitCard]
      (this eq other) || (this.name == other.name && this.effect == other.effect && this.power == other.power)
    } else {
      false
    }
  }

  override def name: String = _name
  override def effect: String = _effect
  override def power: Int = _power
  override def power_(newPower: Int): Unit = super.power_(newPower)

  override def playCard(b: PlayerSide): Unit = {
    b.placeMeleeCard(this)
  }

}
