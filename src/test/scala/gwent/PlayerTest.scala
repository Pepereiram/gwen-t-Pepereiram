package cl.uchile.dcc
package gwent

import munit.FunSuite

class PlayerTest extends FunSuite {
  var Player1: Player = _
  var Player2: Player = _
  var name1: String = "Geralt"
  var name2: String = "Roach"

  override def beforeEach(context: BeforeEach): Unit = {
    /* nombre, sec tab, gems, deck, hand */
    Player1 = new Player(name1)
    Player2 = new Player(name2)
    /*crear decks y cartas de prueba*/
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
