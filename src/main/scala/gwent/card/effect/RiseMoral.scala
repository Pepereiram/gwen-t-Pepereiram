package cl.uchile.dcc
package gwent.card.effect

import gwent.card.ICard

import scala.collection.mutable.ListBuffer

class RiseMoral extends Effect {
  override def apply(self: ICard, zone: ListBuffer[ICard]): Unit = {
    println("Units in the same row get +1 power.")
    //Usar observer
  }
}
