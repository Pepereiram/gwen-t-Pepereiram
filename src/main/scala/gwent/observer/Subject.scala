package cl.uchile.dcc
package gwent.observer

trait Subject[T] {
  def addObserver(observer: Observer[T]):Unit
  def notifyObservers(value: T): Unit
}