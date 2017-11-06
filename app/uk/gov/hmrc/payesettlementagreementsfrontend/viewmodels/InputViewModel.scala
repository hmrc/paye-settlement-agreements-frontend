package uk.gov.hmrc.payesettlementagreementsfrontend.viewmodels

import play.api.data.Form
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.FormHelpers

case class InputViewModel[A](id: String, form: Form[A]) extends InputViewModelBase {
  def errorKey = FormHelpers.getErrorByKey(form, id)
  def value = Some(form.data.getOrElse(id, ""))
}
