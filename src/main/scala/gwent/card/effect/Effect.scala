package cl.uchile.dcc
package gwent.card.effect

import gwent.card.*

import scala.collection.mutable.ListBuffer

/** Trait that dictates the general behavior of a Card's effect */
trait Effect {
  /** Method that applies the Card's effect */
  def apply(self: ICard, zone: ListBuffer[ICard]): Unit
}
