package cl.uchile.dcc
package gwent.player
import munit.FunSuite

class CardTest extends FunSuite {
  var Card1: Card = null
  var Card2: Card = null
  var Card3: Card = null

  override BeforeEach(context: BeforeEach): Unit = {
    /*Cartas tiene nombre y efecto*/
    Card1 = new Card("Triss")
    Card2 = new Card("Geralt")
  }
  test("Cards have names"){
    assertEquals(Card1.name,"Triss")
    assertEquals(Card2.name, "Geralt")
    assertNotEquals(Card1.name, Card2.name)
  }
}
