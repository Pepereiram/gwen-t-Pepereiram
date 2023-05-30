package cl.uchile.dcc
package gwent.board
import gwent.IPlayer
import gwent.card.{ClimateCard, ICard, MeleeUnitCard, RangeUnitCard, SiegeUnitCard}

import scala.collection.mutable.ListBuffer

/** Class representing a Player's Board in the game Gwen't
 *
 * The player's board has space for every kind of Card
 * Only one for ClimateCards (shared by both players)! read the README for more info
 *
 * @constructor Create a new player's board for a given Player
 * @param player Player that uses the board.
 * @param climateSlot Contains the currently active ClimateCard.
 * @param meleeZone where the MeleeUnitCards will be placed
 * @param rangeZone where the RangeUnitCards will be placed
 * @param siegeZone where the SiegeUnitCards will be placed
 * 
 * @author Jose Pereira Morgado
 * @version 1.2
 * @since 1.2
 */
class PlayerSide(val player: IPlayer,
                 var climateSlot: ICard,
                 val meleeZone: ListBuffer[ICard],
                 val rangeZone: ListBuffer[ICard],
                 val siegeZone: ListBuffer[ICard]) extends Equals {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[PlayerSide]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[PlayerSide]
      (this eq other) || (this.player == other.player &&
                          this.meleeZone == other.meleeZone &&
                          this.rangeZone == other.rangeZone &&
                          this.siegeZone == other.siegeZone)
    } else {
      false
    }
  }

  /** Places a ClimateCard on it's Slot */
  def placeClimateCard(cl: ClimateCard): Unit = {
    climateSlot = cl
  }

  /** Places a Melee Card on it's Zone/Row */
  def placeMeleeCard(m : MeleeUnitCard): Unit = {
    meleeZone.addOne(m)
  }

  /** Places a RangeUnitCard on it's Zone/Row */
  def placeRangeCard(r: RangeUnitCard): Unit = {
    meleeZone.addOne(r)
  }

  /** Places a SiegeUnitCard on it's Zone/Row */
  def placeSiegeCard(s: SiegeUnitCard): Unit = {
    meleeZone.addOne(s)
  }

}
