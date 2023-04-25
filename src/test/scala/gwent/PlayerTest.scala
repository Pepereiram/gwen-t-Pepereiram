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
    assertEquals(Player1.getName,name1)
    assertEquals(Player2.getName, name2)
    assertNotEquals(Player1.getName, Player2.getName)
  }

  test("Players have gems"){
    assertEquals(Player1.getGems,2)
    assertEquals(Player2.getGems, Player2.getGems)
  }
  test("Players can lose gems"){
    assertEquals(Player1.getGems,2)
    assert(Player1.setGems(1))
    assertEquals(Player1.getGems,1)
    assert(Player2.setGems(2))
    assertEquals(Player2.getGems,0)
    assert(!Player2.setGems(1))
  }
  test("Player can be compared"){
    assert(Player1.equals(Player1))
    val Player3: IPlayer = new Player(name1,deck)
    assert(Player1.equals(Player3))
    assert(Player3.equals(Player1))
    assert(!Player2.equals(Player1))
    assert(!Player1.equals(climateCard))
  }
  test("Decks can be shuffled"){
    assertEquals(Player1.getDeck, deck)
    assert(Player1.shuffleDeck)
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
    //
    assert(Player1.getHand.nonEmpty)
    assert(Player1.playCard(climateCard))
    //nuevamente no tenemos carta
    assert(!Player1.playCard(climateCard))
  }
}
