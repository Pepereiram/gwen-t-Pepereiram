package cl.uchile.dcc
package gwent.card
import gwent.board.PlayerSide

/** Class that represents the Climate Cards in the game Gwent */
class ClimateCard(val _name: String, val _effect: Effect) extends ICard with Equals{
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

  override def playCard(b: PlayerSide): Unit = {
    b.placeClimateCard(this)
  }
}
