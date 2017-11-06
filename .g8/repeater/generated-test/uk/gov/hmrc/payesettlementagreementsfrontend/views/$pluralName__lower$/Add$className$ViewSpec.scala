package uk.gov.hmrc.payesettlementagreementsfrontend.views.$pluralName;format="lower"$

import play.api.data.Form
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.$pluralName;format="lower"$.routes
import uk.gov.hmrc.payesettlementagreementsfrontend.forms.$className$Form
import uk.gov.hmrc.payesettlementagreementsfrontend.models.{NormalMode, $className$}
import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.QuestionViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.$pluralName;format="lower"$.add$className$

class Add$className$ViewSpec extends QuestionViewBehaviours[$className$] {

  val messageKeyPrefix = "$pluralName;format="decap"$.add"

  def createView = () => add$className$(frontendAppConfig, $className$Form(), NormalMode)(fakeRequest, messages)

  def createViewUsingForm = (form: Form[$className$]) => add$className$(frontendAppConfig, form, NormalMode)(fakeRequest, messages)

  override val form = $className$Form()

  "Add $className$ view" must {

    behave like normalPage(createView, messageKeyPrefix)

    behave like pageWithTextFields(createViewUsingForm, messageKeyPrefix, routes.Add$className$Controller.onSubmit(NormalMode).url, "field1", "field2")
  }
}
