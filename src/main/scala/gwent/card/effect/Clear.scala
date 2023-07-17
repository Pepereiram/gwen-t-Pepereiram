package cl.uchile.dcc
package gwent.card.effect

import gwent.card.ICard

import scala.collection.mutable.ListBuffer

class Clear extends Effect {
  override def apply(self: ICard, zone: ListBuffer[ICard]): Unit = {
    println("All Units power set to default.")
    //Usar observer
  }
}
