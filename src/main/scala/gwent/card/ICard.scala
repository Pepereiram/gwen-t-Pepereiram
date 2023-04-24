package cl.uchile.dcc
package gwent.card

/** Trait that dictates the general behavior of a Card */
trait ICard {
  /** Method that returns the Card's name */
  val name: String
  val effect: String
  def getName (): String
  def getEffect(): String

}
