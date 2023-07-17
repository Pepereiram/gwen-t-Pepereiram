package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** Represents a state in the game Gwen't.
 * State Design Pattern
 *
 * It serves as a base behaviour for a state within the game Gwen't.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new game state with a given context.
 * @author José Pereira
 * @since 1.3
 * @version 1.3
 */
class GameState protected(val context : GameController) extends Equals {
  
  context.state = this

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[GameState]
      (this eq other) || (this.context == other.context)
    } else {
      false
    }
  }
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[GameState]
  }
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }

  /** Transition the game state to [[StartingState]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toStartingState():Unit ={
    transitionError("StartingState")
  }

  /** Transition the game state to [[IdleState]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toIdleState():Unit = {
    transitionError("IdleState")
  }

  /** Transition the game state to [[CPUPlaying]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toCPUPlaying():Unit = {
    transitionError("CPUPlaying")
  }

  /** Transition the game state to [[DrawingCard]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toDrawingCard(): Unit = {
    transitionError("DrawingCard")
  }

  /** Transition the game state to [[EndingRound]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toEndingRound(): Unit = {
    transitionError("EndingRound")
  }

  /** Transition the game state to [[GameEnd]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toGameEnd(): Unit = {
    transitionError("GameEnd")
  }

  /** Transition the game state to [[PassingTurn]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toPassingTurn(): Unit = {
    transitionError("PassingTurn")
  }

  /** Transition the game state to [[PlayingCard]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toPlayingCard(): Unit = {
    transitionError("PlayingCard")
  }

  /** Transition the game state to [[WinCondition]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toWinCondition(): Unit = {
    transitionError("WinCondition")
  }

  /** Transition the game state to [[PlayerMenu]].
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toPlayerMenu(): Unit = {
    transitionError("PlayerMenu")
  }

}
