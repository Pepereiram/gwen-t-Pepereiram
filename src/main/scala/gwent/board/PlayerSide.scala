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
 * @param _player Player that uses the board.
 * @param _climateSlot Contains the currently active ClimateCard.
 * @param _meleeZone where the MeleeUnitCards will be placed
 * @param _rangeZone where the RangeUnitCards will be placed
 * @param _siegeZone where the SiegeUnitCards will be placed
 * 
 * @author Jose Pereira Morgado
 * @version 1.2
 * @since 1.2
 */
class PlayerSide(private val _player: IPlayer,
                 private var _climateSlot: ICard,
                 private val _meleeZone: ListBuffer[ICard],
                 private val _rangeZone: ListBuffer[ICard],
                 private val _siegeZone: ListBuffer[ICard]) extends Equals {
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[PlayerSide]
  }
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[PlayerSide]
      (this eq other) || (this.player == other.player &&
                          this.climateSlot == other.climateSlot &&
                          this.meleeZone == other.meleeZone &&
                          this.rangeZone == other.rangeZone &&
                          this.siegeZone == other.siegeZone)
    } else {
      false
    }
  }
  //GETTES & SETTERS
  def player: IPlayer = _player
  def climateSlot: ICard = _climateSlot
  def meleeZone: ListBuffer[ICard] = _meleeZone
  def rangeZone: ListBuffer[ICard] = _rangeZone
  def siegeZone: ListBuffer[ICard] = _siegeZone

  /** Places a ClimateCard on it's Slot */
  def placeClimateCard(cl: ClimateCard): Unit = {
    _climateSlot = cl
  }

  /** Places a Melee Card on it's Zone/Row */
  def placeMeleeCard(m : MeleeUnitCard): Unit = {
    meleeZone.addOne(m)
  }

  /** Places a RangeUnitCard on it's Zone/Row */
  def placeRangeCard(r: RangeUnitCard): Unit = {
    rangeZone.addOne(r)
  }

  /** Places a SiegeUnitCard on it's Zone/Row */
  def placeSiegeCard(s: SiegeUnitCard): Unit = {
    siegeZone.addOne(s)
  }

}
