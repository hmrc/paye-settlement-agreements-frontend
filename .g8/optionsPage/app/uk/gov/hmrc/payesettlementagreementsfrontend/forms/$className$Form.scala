package uk.gov.hmrc.payesettlementagreementsfrontend.forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formatter
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.RadioOption

object $className$Form extends FormErrorHelper {

  def $className$Formatter = new Formatter[String] {
    def bind(key: String, data: Map[String, String]) = data.get(key) match {
      case Some(s) if optionIsValid(s) => Right(s)
      case None => produceError(key, "error.required")
      case _ => produceError(key, "error.unknown")
    }

    def unbind(key: String, value: String) = Map(key -> value)
  }

  def apply(): Form[String] = 
    Form(single("value" -> of($className$Formatter)))

  def options = Seq(
    RadioOption("$className;format="decap"$", "option1"),
    RadioOption("$className;format="decap"$", "option2")
  )

  def optionIsValid(value: String) = options.exists(o => o.value == value)
}
