package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class CardTest extends FunSuite {
  var Card1: Card = _
  var Card2: Card = _
  override def beforeEach(context: BeforeEach): Unit = {
    /*Cartas tiene nombre y efecto*/
    Card1 = new Card("Triss",null)
    Card2 = new Card("Geralt",null)
  }
  test("Cards have names"){
    assertEquals(Card1.name,"Triss")
    assertEquals(Card2.name, "Geralt")
    assertNotEquals(Card1.name, Card2.name)
  }
}
