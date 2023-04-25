package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class ClimateCardTest extends FunSuite{
  var card1: ICard = _
  var card2: ICard = _
  val name1: String = "Lluvia Torrencial"
  val effect1: String = "Rain"
  val name2: String = "Clima Despejado"
  val effect2: String = "None"

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new ClimateCard(name1,effect1)
    card2 = new ClimateCard(name2,effect2)
  }

  test("Cards have names"){
    assertEquals(card1.getName,name1)
    assertEquals(card2.getName,name2)
    assertNotEquals(card1.getEffect,card2.getName)
  }
  test("Card have effects"){
    assertEquals(card1.getEffect,effect1)
    assertEquals(card2.getEffect,effect2)
    assertNotEquals(card1.getEffect,card2.getEffect)
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
}
