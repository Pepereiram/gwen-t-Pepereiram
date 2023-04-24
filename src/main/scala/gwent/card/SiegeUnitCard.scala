package cl.uchile.dcc
package gwent.card

/** Class that represents a Siege Unit Card in the game Gwent */
class SiegeUnitCard(name: String, effect: String, power: Int) extends AbstractUnitCard(name,effect,power) with Equals {
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
  override def getName(): String = {
    this.name
  }
  override def getEffect(): String = {
    this.effect
  }
  override def getPower(): Int = {
    this.power
  }
  override def setPower(value: Int): Unit = {
    super.setPower(value)
  }

}
