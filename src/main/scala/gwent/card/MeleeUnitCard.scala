package cl.uchile.dcc
package gwent.card
import gwent.board.PlayerSide

/** Class that represents a Melee Unit Card in the game Gwent */
class MeleeUnitCard(name: String, effect: String, power: Int) extends AbstractUnitCard(name, effect, power) with Equals {
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

  override def playCard(b: PlayerSide): Unit = {
    b.placeMeleeCard(this)
  }

}
