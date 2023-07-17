package cl.uchile.dcc
package gwent

import gwent.states.*
import munit.FunSuite

class GameControllerTest extends FunSuite{
  var controller: GameController = _
  override def beforeEach(context: BeforeEach): Unit = {
    controller= new GameController
  }
  test("Controller starts at StartingState"){
    val testState: GameState = new IdleState(controller)
    assert(controller.state.equals(testState))
  }
}
