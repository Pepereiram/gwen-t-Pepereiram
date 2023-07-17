package cl.uchile.dcc
package gwent.card
import gwent.board.PlayerSide

/** Class that represents the Unit Cards in the game Gwent */
abstract class AbstractUnitCard(protected val _name: String, protected val _effect: Effect,
                                protected var _power: Int) extends ICard with Equals {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[AbstractUnitCard]
  }
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbstractUnitCard]
      (this eq other) || (this.name == other.name && this.effect == other.effect && this._power == other._power)
    } else {
      false
    }
  }
  override def name: String = _name

  override def effect: Effect = _effect
  /** Method that returns the power from a Unit Card */
  def power: Int = _power
  /** Method that changed the value of power from a Unit Card */
  def power_(newPower: Int): Unit = {
    _power = newPower
  }
  override def playCard(b: PlayerSide): Unit
}
