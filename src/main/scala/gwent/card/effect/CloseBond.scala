package cl.uchile.dcc
package gwent.card.effect

import gwent.card.ICard

import scala.collection.mutable.ListBuffer

class CloseBond extends Effect {
  override def apply(self: ICard, zone: ListBuffer[ICard]): Unit = {
    println("Units with the same name double their attack.")
    //Usar observer
  }
}
