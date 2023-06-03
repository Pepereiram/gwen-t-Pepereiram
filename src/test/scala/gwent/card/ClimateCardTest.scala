package cl.uchile.dcc
package gwent.card

import gwent.{IPlayer, Player}

import gwent.board.PlayerSide
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class ClimateCardTest extends FunSuite{
  var card1: ICard = _
  var card2: ICard = _
  val name1: String = "Lluvia Torrencial"
  val effect1: String = "Rain"
  val name2: String = "Clima Despejado"
  val effect2: String = "None"
  val player: IPlayer = new Player("player",new ListBuffer[ICard], new ListBuffer[ICard])
  val playerSide: PlayerSide = new PlayerSide(player, new ClimateCard("", ""),
                                              new ListBuffer[ICard], new ListBuffer[ICard], new ListBuffer[ICard])

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new ClimateCard(name1,effect1)
    card2 = new ClimateCard(name2,effect2)
  }

  test("Cards have names"){
    assertEquals(card1.name,name1)
    assertEquals(card2.name,name2)
    assertNotEquals(card1.effect,card2.name)
  }
  test("Card have effects"){
    assertEquals(card1.effect,effect1)
    assertEquals(card2.effect,effect2)
    assertNotEquals(card1.effect,card2.effect)
  }
  test("Cards can be compared"){
    val card3: ICard = new ClimateCard(name1,effect1)
    assert(card1.equals(card3))
    assert(card1.equals(card1))
    assert(!card1.equals(card2))
    val card4: ICard = new RangeUnitCard(name1, effect1, 3)
    val card5: ICard = new SiegeUnitCard(name2, effect2, 3)
    val card6: ICard = new MeleeUnitCard(name1,effect2,3)
    //compared to different card class
    assert(!card1.equals(card4))
    assert(!card1.equals(card5))
    assert(!card1.equals(card6))
  }
  test("ClimateCards can be played"){
    //Debantiendo si hacer estos test aquí o solo para PlayerSide
  }
}
