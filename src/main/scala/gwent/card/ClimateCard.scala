package cl.uchile.dcc
package gwent.card

/** Class that represents the Climate Cards in the game Gwent */
class ClimateCard(name: String, effect: String) extends AbstractCard(name, effect) with Equals{
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[ClimateCard]
  }
  override def equals(that: Any): Boolean = {
    if (canEqual(that)){
      val other = that.asInstanceOf[ClimateCard]
      (this eq other) || (this.name == other.name && this.effect == other.effect)
    } else {
      false
    }
  }
  override def getEffect: String = {
    this.effect
  }
  override def getName: String = {
    this.name
  }
}
