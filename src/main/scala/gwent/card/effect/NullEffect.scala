package cl.uchile.dcc
package gwent.card.effect
import gwent.card.ICard

import java.lang.annotation.Target
import scala.collection.mutable.ListBuffer

class NullEffect extends Effect {
  override def apply(self: ICard, target: ListBuffer[ICard]): Unit = {
    //Nothing
  }
}
