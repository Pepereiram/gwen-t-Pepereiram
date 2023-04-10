package cl.uchile.dcc
package gwent.player
import munit.FunSuite

class PlayerTest extends FunSuite {
  var Player1: Player = null
  var Player2: Player = null

  override def BeforeEach(context: BeforeEach): Unit = {
    /* nombre, sec tab, gems, deck, hand */
    Player1 = new Player("Geralt")
    Player2 = new Player("Roach")
    /*crear decks y cartas de prueba*/
  }

  test("Players have names"){
    assertEquals(Player1.name,"Geralt")
    assertEquals(Player2.name, "Roach")
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
  test("Players have cards in hand"){
    /*ponemos cartas en sus manos*/
  }
  test("Players can play cards") {
    /*juegan una carta en la mano*/
  }
  test("Players draw cards"){
    /*roban cartas del deck (3)*/
  }
}
