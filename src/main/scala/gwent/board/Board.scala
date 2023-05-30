package cl.uchile.dcc
package gwent.board
import gwent.card.{ClimateCard, ICard, MeleeUnitCard, RangeUnitCard, SiegeUnitCard}
import gwent.IPlayer


/** Class representing a Board in the game Gwen't
 *
 * The board has players and zones for each player.
 * 
 * @constructor Create a new board with two players
 * @param side1 Player 1.
 * @param side2 Player 2.
 * @param climateSlot where the ClimateCard is placed
 *
 * @author Jose Pereira Morgado
 * @version 1.2
 * @since 1.2
 */
class Board(val side1: PlayerSide, val side2: PlayerSide, var climateSlot: ClimateCard) extends Equals{

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Board]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Board]
      (this eq other) || (this.side1 == other.side1 && this.side2 == other.side2)
    } else {
      false
    }
  }

  /** Places a ClimateCard on it's Slot */
  def placeClimateCard(cl: ClimateCard): Unit = {
    climateSlot = cl
  }
  
  def placeMeleeCard(m: MeleeUnitCard): Unit = {
    side1.placeMeleeCard(m)
  }

  def placeRangeCard(r: RangeUnitCard): Unit = {
    side1.placeRangeCard(r)
  }

  def placeSiegeCard(s: SiegeUnitCard): Unit = {
    side1.placeSiegeCard(s)
  }
}
