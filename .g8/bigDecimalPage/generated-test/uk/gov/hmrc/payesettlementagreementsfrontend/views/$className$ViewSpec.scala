package uk.gov.hmrc.payesettlementagreementsfrontend.views

import play.api.data.Form
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.routes
import uk.gov.hmrc.payesettlementagreementsfrontend.forms.$className$Form
import uk.gov.hmrc.payesettlementagreementsfrontend.models.NormalMode
import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.BigDecimalViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.$className;format="decap"$

class $className$ViewSpec extends BigDecimalViewBehaviours {

  val messageKeyPrefix = "$className;format="decap"$"

  def createView = () => $className;format="decap"$(frontendAppConfig, $className$Form(), NormalMode)(fakeRequest, messages)

  def createViewUsingForm = (form: Form[BigDecimal]) => $className;format="decap"$(frontendAppConfig, form, NormalMode)(fakeRequest, messages)

  val form = $className$Form()

  "$className$ view" must {
    behave like normalPage(createView, messageKeyPrefix)

    behave like pageWithBackLink(createView)

    behave like intPage(createViewUsingForm, messageKeyPrefix, routes.$className$Controller.onSubmit(NormalMode).url)
  }
}
