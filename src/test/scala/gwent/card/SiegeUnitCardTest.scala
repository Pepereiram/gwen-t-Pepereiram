package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class SiegeUnitCardTest extends FunSuite{
  var card1: AbstractUnitCard = _
  var card2: AbstractUnitCard = _
  val name1: String = "Geralt"
  val name2: String = "Roach"
  val effect1: String = "a"
  val effect2: String = "b"
  val power1: Int = 5
  val power2: Int = 2

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new SiegeUnitCard(name1, effect1, power1)
    card2 = new SiegeUnitCard(name2, effect2, power2)
  }

  test("Cards have names") {
    assertEquals(card1.name, name1)
    assertEquals(card2.name, name2)
    assertNotEquals(card1.name, card2.name)
  }
  test("Card have effects") {
    assertEquals(card1.effect, effect1)
    assertEquals(card2.effect, effect2)
    assertNotEquals(card1.effect, card2.effect)
  }
  test("Siege Cards have power") {
    assertEquals(card1.power, power1)
    assertEquals(card2.power, power2)
    assertNotEquals(card1.power, card2.power)
    card1.power_(10)
    assertEquals(card1.power, 10)
  }
  test("Cards can be compared") {
    val card3: ICard = new SiegeUnitCard(name1, effect1, power1)
    //compared to itself
    assert(card1.equals(card1))
    //compared to an identical card
    assert(card1.equals(card3))
    //compared to a different card
    assert(!card1.equals(card2))
    val card4: ICard = new RangeUnitCard(name1, effect1, power1)
    val card5: ICard = new MeleeUnitCard(name2, effect2, power2)
    //compared to different class with same params
    assert(!card1.equals(card4))
    //compared to different class with diff params
    assert(!card1.equals(card5))
    val card6: ICard = new ClimateCard(name1, effect1)
    assert(!card1.equals(card6))
  }
}
