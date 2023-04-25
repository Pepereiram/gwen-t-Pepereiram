package cl.uchile.dcc
package gwent.card

/** Class that represents the Unit Cards in the game Gwent */
abstract class AbstractUnitCard(name: String, effect: String, var power: Int) extends AbstractCard(name,effect) with Equals {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[AbstractUnitCard]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbstractUnitCard]
      (this eq other) || (this.name == other.name && this.effect == other.effect && this.power == other.power)
    } else {
      false
    }
  }
  /** Method that returns the power from a Unit Card */
  def getPower: Int = this.power

  /** Method that changed the value of power from a Unit Card */
  def setPower(value: Int): Unit = {
    this.power = value
  }
}
