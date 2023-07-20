package cl.uchile.dcc
package gwent.card.effect

import gwent.card.ICard

import scala.collection.mutable.ListBuffer

class Frost extends Effect {
  override def apply(self: ICard, zone: ListBuffer[ICard]): Unit = {
    println("Melee Units power set to 1.")
    //Usar observer
  }
}
