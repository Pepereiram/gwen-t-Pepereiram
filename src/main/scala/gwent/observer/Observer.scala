package cl.uchile.dcc
package gwent.observer

trait Observer[T] {
  def update(observable: Subject[T], value: T): Unit
}
