package sample

import rx._

object ScalaRxSample extends App {

  sample3()

  def sample1(): Unit = {
    val a = Var(1)
    val b = Var(2)
    val c = Rx{a() + b()}
    println(c())
    a() = 4
    println(c())
  }

  def sample2(): Unit = {
    val a = Var(1)
    val b = Var(2)

    val c = Rx{ a() + b() }
    val d = Rx{ c() * 5 }
    val e = Rx{ c() + 4 }
    val f = Rx{ d() + e() + 4 }

    println(f())
    a() = 3
    println(f())
  }

  def sample3() {
    val a = Var(1)
    var count = 0
    val o = Obs(a) {
      count = a() + 1
    }
    println(count)
    a() = 4
    println(count)
  }
}
