package cl.uchile.dcc
package gwent

import gwent.IPlayer
import gwent.board.PlayerSide
import gwent.card.ICard
import gwent.states.{GameState, IdleState, StartingState}

import cl.uchile.dcc.gwent.observer.{Observer, Subject}

/** Controller from the videogame Gwen't
 *  This implementation considers a game between a CPU-Player and a Human-Player
 *
 * @constructor Creates a new GameController for the game.
 * @author José Pereira
 * @since 1.3
 * @version 1.3
 *  */
class GameController extends Observer[EndCondition] {
  var state: GameState = new StartingState(this)

  override def update(observable: Subject[EndCondition], value: EndCondition): Unit = {
    val endCondition = value.asInstanceOf[EndCondition]
    println(s"The game has finished due to $observable ${endCondition.name}")
    this.endGame()
  }

  def startGame(): Unit ={
    //The necessary var/val are created for the game to start
    state.toIdleState()
  }
  def cpuTurn(): Unit = {
    state.toCPUPlaying()
  }

  def endCpuTurn(): Unit = {
    state.toIdleState()
  }

  def playerTurn(): Unit = {
    state.toPlayerMenu()
  }

  def drawCard(): Unit = {
    state.toDrawingCard()
  }

  def playCard(): Unit = {
    state.toPlayingCard()
  }
  def passTurn(): Unit = {
    //When passing, the other player is free to keep playing
    state.toPassingTurn()
  }
  def endTurn(): Unit = {
    //Player ends turn by passing or playing a card
    state.toIdleState()
  }
  def endRound(): Unit = {
    //the game loop ends
    state.toEndingRound()
  }
  def results(): Unit = {
    //the power is calculated on each side
    state.toWinCondition()//<- Here the values of the gems are changed triggering the potential end of the game.
  }
  def nextRound(): Unit = {
    //Condition is not met. 1 more round.
    state.toIdleState()
  }
  def endGame(): Unit = {
    //The condition is met
    state.toGameEnd()
  }
}
