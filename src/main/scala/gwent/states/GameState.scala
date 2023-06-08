package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** Represents a state in the game Gwen't.
 *  State Design Pattern
 *
 * It serves as a base behaviour for a state within the game Gwen't.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new game state with a given context.
 * @author José Pereira
 * @since 1.3
 * @version 1.3
 */
class GameState protected(val context : GameController) {

  context.state = this

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
  def toStartingState():Unit ={
    transitionError("StartingState")
  }
  def toIdleState():Unit = {
    transitionError("IdleState")
  }
  def toCPUPlaying():Unit = {
    transitionError("CPUPlaying")
  }
  def toDrawingCard(): Unit = {
    transitionError("DrawingCard")
  }
  def toEndingRound(): Unit = {
    transitionError("EndingRound")
  }
  def toGameEnd(): Unit = {
    transitionError("GameEnd")
  }
  def toPassingTurn(): Unit = {
    transitionError("PassingTurn")
  }
  def toPlayingCard(): Unit = {
    transitionError("PlayingCard")
  }
  def toWinCondition(): Unit = {
    transitionError("WinCondition")
  }
  def toPlayerMenu(): Unit = {
    transitionError("PlayerMenu")
  }

}
