package uk.gov.hmrc.payesettlementagreementsfrontend.views

import play.api.data.Form
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.routes
import uk.gov.hmrc.payesettlementagreementsfrontend.forms.BooleanForm
import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.YesNoViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.models.NormalMode
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.$className;format="decap"$

class $className$ViewSpec extends YesNoViewBehaviours {

  val messageKeyPrefix = "$className;format="decap"$"

  def createView = () => $className;format="decap"$(frontendAppConfig, BooleanForm(), NormalMode)(fakeRequest, messages)

  def createViewUsingForm = (form: Form[Boolean]) => $className;format="decap"$(frontendAppConfig, form, NormalMode)(fakeRequest, messages)

  "$className$ view" must {

    behave like normalPage(createView, messageKeyPrefix)

    behave like yesNoPage(createViewUsingForm, messageKeyPrefix, routes.$className$Controller.onSubmit(NormalMode).url)
  }
}
