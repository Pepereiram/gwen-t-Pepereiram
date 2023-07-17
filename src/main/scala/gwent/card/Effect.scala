package cl.uchile.dcc
package gwent.card

import gwent.card.*

/** Trait that dictates the general behavior of a Card's effect */
trait Effect {
  /** Method that applies the Card's effect */
  def apply(self: ICard): Unit
}
