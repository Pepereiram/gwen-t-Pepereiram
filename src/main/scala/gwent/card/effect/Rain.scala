package cl.uchile.dcc
package gwent.card.effect
import gwent.card.ICard

import cl.uchile.dcc.gwent.observer.Subject

import scala.collection.mutable.ListBuffer

class Rain extends Effect{
  override def apply(self: ICard, zone: ListBuffer[ICard]): Unit = {
    println("Siege Units power set to 1.")
    //Usar observer
  }
}
