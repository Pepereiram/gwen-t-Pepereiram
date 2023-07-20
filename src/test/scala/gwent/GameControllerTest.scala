package cl.uchile.dcc
package gwent

import gwent.states.*

import cl.uchile.dcc.gwent.card.ICard
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class GameControllerTest extends FunSuite{
  var controller: GameController = _
  override def beforeEach(context: BeforeEach): Unit = {
    controller= new GameController
  }
  test("Controller starts at StartingState"){
    assert(controller.state.equals(new StartingState(controller)))
    assert(!controller.state.equals(new IdleState(controller)))
  }
  test("StartingState transitions to IdleState"){
    controller.startGame()
    assert(controller.state.equals(new IdleState(controller)))
  }
  test("Controller transitions through a CPUTURN"){
    controller.startGame()
    assert(controller.state.equals(new IdleState(controller)))
    controller.cpuTurn()
    assert(controller.state.equals(new CPUPlaying(controller)))
    controller.endCpuTurn()
    assert(controller.state.equals(new IdleState(controller)))
  }
  test("Controller transitions to the next Round"){
    controller.startGame()
    controller.endRound()
    assert(controller.state.equals(new EndingRound(controller)))
    controller.results()
    assert(controller.state.equals(new WinCondition(controller)))
    controller.nextRound()
    assert(controller.state.equals(new IdleState(controller)))
  }
  test("Controller transitions through a Player drawing and playing a Card"){
    controller.startGame()
    controller.playerTurn()
    assert(controller.state.equals(new PlayerMenu(controller)))
    controller.drawCard()
    assert(controller.state.equals(new DrawingCard(controller)))
    controller.playerTurn()
    assert(controller.state.equals(new PlayerMenu(controller)))
    controller.playCard()
    assert(controller.state.equals(new PlayingCard(controller)))
    controller.endTurn()
    assert(controller.state.equals(new IdleState(controller)))
  }
  test("Controllers can pass a players turn"){
    controller.startGame()
    controller.playerTurn()
    controller.passTurn()
    assert(controller.state.equals(new PassingTurn(controller)))
    controller.endTurn()
    assert(controller.state.equals(new IdleState(controller)))
  }
  test("Controller can end a game"){
    controller.startGame()
    controller.endRound()
    controller.results()
    controller.endGame()
    assert(controller.state.equals(new GameEnd(controller)))
  }
}
