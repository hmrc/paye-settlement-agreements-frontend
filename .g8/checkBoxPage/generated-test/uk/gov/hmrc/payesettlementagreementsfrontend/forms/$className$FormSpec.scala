package uk.gov.hmrc.payesettlementagreementsfrontend.forms

import uk.gov.hmrc.payesettlementagreementsfrontend.forms.behaviours.CheckboxBehaviours

class $className$FormSpec extends CheckboxBehaviours[String] {

  override val validOptions: Set[String] = Set("option1", "option2")

  override val fieldName = "value"

  val form = $className$Form()

  "$className$ form" must {
    behave like aCheckboxForm(invalid = "error.unknown")
  }
}
