package cl.uchile.dcc
package gwent

import munit.FunSuite
import gwent.card.*

import scala.collection.mutable.ListBuffer

class PlayerTest extends FunSuite {
  var Player1: Player = _
  var Player2: Player = _
  val name1: String = "Geralt"
  val name2: String = "Roach"
  val climateCard: ICard = new ClimateCard("cartita",null)
  val siegeCard: ICard = new SiegeUnitCard("cartota","null",5)
  val meleeCard1: ICard = new MeleeUnitCard("Juan","null",3)
  val meleeCard2: ICard = new MeleeUnitCard("Geralt","null",4)
  val rangeCard: ICard = new RangeUnitCard("Daff", null,2)
  val deck: ListBuffer[ICard] = ListBuffer(climateCard,meleeCard1,meleeCard2,rangeCard,siegeCard)
  override def beforeEach(context: BeforeEach): Unit = {
    Player1 = new Player(name1,deck)
    Player2 = new Player(name2,deck)
  }

  test("Players have names"){
    assertEquals(Player1.name,name1)
    assertEquals(Player2.name, name2)
    assertNotEquals(Player1.name, Player2.name)
  }

  test("Players have gems"){
    assertEquals(Player1.gems,2)
    assertEquals(Player2.gems, Player2.gems)
    /*Probar en el futuro el perder gemas*/
  }
  test("Players have decks"){

    /*les damos decks y verificamos*/
  }
  test("Players can draw cards"){
    assert(Player1.deck.nonEmpty)
    assert(Player2.deck.nonEmpty)
    assert(Player1.drawCards())//1
    assert(Player1.drawCards())//2
    assert(Player1.drawCards())//3
    assert(Player1.drawCards())//4
    assert(Player1.drawCards())//5
    //No quedan cartas
    assert(!Player1.drawCards())
  }
  test("Players can play cards from their hands") {
    //No tiene cartas en mano
    assert(!Player1.playCard(climateCard))
    //obtnemos carta y la jugamos
    Player1.drawCards()
    assert(Player1.playCard(climateCard))
    //nuevamente no tenemos carta
    assert(!Player1.playCard(climateCard))
  }
  test("Players draw cards"){
    /*roban cartas del deck (3)*/
  }
}
