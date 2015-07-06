package sample

import scala.scalajs.js.JSApp
import org.scalajs.jquery.{jQuery => $, JQueryEventObject}
import org.scalajs.dom._
import rx._

object ScalaRxSampleJs extends JSApp {
  def main(): Unit = {
    val text = Var($("#text").value().asInstanceOf[String])
    val copy = Rx {$("#copy").text(text())}
    val iya = Rx { text() match {
      case s if s.length % 2 == 0 => $("#iya").hide()
      case _ => $("#iya").show()
    }}

    $(document).ready {
      JQueryRx.change("#text", text)
    }
  }
}

object JQueryRx {
  def change[V](selector: String, rxVar: Var[V]): Unit = {
    $("#text").on("change", (e: JQueryEventObject) => {
      rxVar() = $(selector).value().asInstanceOf[V]
    })
  }
}
