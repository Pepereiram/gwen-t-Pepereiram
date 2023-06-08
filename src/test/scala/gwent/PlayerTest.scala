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
  val hand: ListBuffer[ICard] = ListBuffer()
  override def beforeEach(context: BeforeEach): Unit = {
    Player1 = new Player(name1,deck,hand)
    Player2 = new Player(name2,deck,hand)
  }

  test("Players have names"){
    assertEquals(Player1.name,name1)
    assertEquals(Player2.name, name2)
    assertNotEquals(Player1.name, Player2.name)
  }

  test("Players have gems"){
    assertEquals(Player1.gems,2)
    assertEquals(Player2.gems, Player2.gems)
  }
  test("Players can lose gems"){
    assertEquals(Player1.gems,2)
    Player1.gems_(1)
    assertEquals(Player1.gems,1)
    Player2.gems_(2)
    assertEquals(Player2.gems,0)
  }
  test("Player can be compared"){
    assert(Player1.equals(Player1))
    val Player3: IPlayer = new Player(name1,deck,hand)
    assert(Player1.equals(Player3))
    assert(Player3.equals(Player1))
    assert(!Player2.equals(Player1))
    assert(!Player1.equals(climateCard))
  }
  test("Decks can be shuffled"){
    assertEquals(Player1.deck, deck)
    assert(Player1.shuffleDeck)
    val emptyDeck : ListBuffer[ICard] = new ListBuffer()
    val player3: IPlayer = new Player(name1,emptyDeck,hand)
    assert(!player3.shuffleDeck)
  }
  test("Players can draw cards"){
    assert(Player1.deck.nonEmpty)
    assert(Player2.deck.nonEmpty)
    assert(Player1.drawCard())//1
    assert(Player1.drawCard())//2
    assert(Player1.drawCard())//3
    assert(Player1.drawCard())//4
    assert(Player1.drawCard())//5
    //No quedan cartas
    assert(!Player1.drawCard())
  }
  test("Players can play cards from their hands") {
    //No tiene cartas en mano
    assert(!Player1.playCard(climateCard))
    //obtnemos carta y la jugamos
    Player1.drawCard()
    //
    assert(Player1.hand.nonEmpty)
    assert(Player1.playCard(climateCard))
    //nuevamente no tenemos carta
    assert(!Player1.playCard(climateCard))
  }
}
