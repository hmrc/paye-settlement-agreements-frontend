package uk.gov.hmrc.payesettlementagreementsfrontend.utils

import play.api.data.Form

object FormHelpers {

  def getErrorByKey[A](form: Form[A], errorKey: String) = {
    form.error(errorKey) match {
      case None => ""
      case Some(error) => error.message
    }
  }
}
