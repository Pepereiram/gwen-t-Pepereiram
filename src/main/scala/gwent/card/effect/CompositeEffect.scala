package cl.uchile.dcc
package gwent.card.effect
import gwent.card.ICard

import scala.collection.mutable.ListBuffer

class CompositeEffect(val effects: List[Effect]) extends Effect {
  override def apply(self: ICard, zone: ListBuffer[ICard]): Unit = {
    for (effect <- effects) {
      effect.apply(self, zone)
    }
  }

}
