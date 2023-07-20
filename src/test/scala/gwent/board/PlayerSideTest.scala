package cl.uchile.dcc
package gwent.board

import gwent.card.*
import gwent.{IPlayer, Player}
import gwent.card.effect.*
import munit.FunSuite
import scala.collection.mutable.ListBuffer

class PlayerSideTest extends FunSuite{
  val noneClimate: ICard = new ClimateCard("None", new NullEffect())
  val rainClimate: ICard = new ClimateCard("Rain",new NullEffect())
  val melee: ICard = new MeleeUnitCard("Melee", new NullEffect(),5)
  val range: ICard = new RangeUnitCard("Ranged", new NullEffect(), 3)
  val siege: ICard = new SiegeUnitCard("Siege", new NullEffect(), 6)
  val player1: IPlayer = new Player("Homero", new ListBuffer[ICard], new ListBuffer[ICard])
  val player2: IPlayer = new Player("Juan", new ListBuffer[ICard], new ListBuffer[ICard])
  val meleeZone1: ListBuffer[ICard] = new ListBuffer()
  val rangeZone1: ListBuffer[ICard] = new ListBuffer()
  val siegeZone1: ListBuffer[ICard] = new ListBuffer()
  val meleeZone2: ListBuffer[ICard] = new ListBuffer()
  val rangeZone2: ListBuffer[ICard] = new ListBuffer()
  val siegeZone2: ListBuffer[ICard] = new ListBuffer()
  var side1: PlayerSide = _
  var side2: PlayerSide = _

  override def beforeEach(context: BeforeEach): Unit = {
    side1 = new PlayerSide(player1,noneClimate,meleeZone1, rangeZone1, siegeZone1)
    side2 = new PlayerSide(player2,noneClimate,meleeZone2,rangeZone2,siegeZone2)
  }

  test("PlayerSides can be compared"){
    assert(!side1.equals(side2))
    assert(side1.equals(side1))
    val side3 : PlayerSide = new PlayerSide(player1,noneClimate,meleeZone1, rangeZone1, siegeZone1)
    assert(side1.equals(side3))
    assert(!side1.equals(noneClimate))
  }
  test("PlayerSide has params"){
    assertEquals(side1.player,player1)
    assertEquals(side1.climateSlot,noneClimate)
    assertEquals(side1.meleeZone,meleeZone1)
    assertEquals(side1.rangeZone,rangeZone1)
    assertEquals(side1.siegeZone,siegeZone2)
  }
  test("PlayerSide can Place ClimateCards"){
    assertEquals(side1.climateSlot, noneClimate)
    rainClimate.playCard(side1)
    assertEquals(side1.climateSlot,rainClimate)
  }
  test("PlayerSide can Place MeleeCards") {
    assertEquals(side1.meleeZone.isEmpty, true)
    melee.playCard(side1)
    assertEquals(side1.meleeZone.isEmpty, false)
    assert(side1.meleeZone.contains(melee))
  }
  test("PlayerSide can Place RangeCards") {
    assertEquals(side1.rangeZone.isEmpty, true)
    range.playCard(side1)
    assertEquals(side1.rangeZone.isEmpty, false)
    assert(side1.rangeZone.contains(range))
  }
  test("PlayerSide can Place SiegeCards") {
    assertEquals(side1.siegeZone.isEmpty, true)
    siege.playCard(side1)
    assertEquals(side1.siegeZone.isEmpty, false)
    assert(side1.siegeZone.contains(siege))
  }

}
