package uk.gov.hmrc.payesettlementagreementsfrontend.views.$pluralName;format="lower"$

import play.api.data.Form
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.$pluralName;format="lower"$.routes
import uk.gov.hmrc.payesettlementagreementsfrontend.forms.$className$Form
import uk.gov.hmrc.payesettlementagreementsfrontend.models.{NormalMode, $className$}
import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.QuestionViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.$pluralName;format="lower"$.edit$className$

class Edit$className$ViewSpec extends QuestionViewBehaviours[$className$] {

  val messageKeyPrefix = "$pluralName;format="decap"$.edit"

  val index = 0

  def createView = () => edit$className$(index, frontendAppConfig, $className$Form(), NormalMode)(fakeRequest, messages)

  def createViewUsingForm = (form: Form[$className$]) => edit$className$(index, frontendAppConfig, form, NormalMode)(fakeRequest, messages)

  override val form = $className$Form()

  "Edit $className$ view" must {

    behave like normalPage(createView, messageKeyPrefix)

    behave like pageWithTextFields(createViewUsingForm, messageKeyPrefix, routes.Edit$className$Controller.onSubmit(index, NormalMode).url, "field1", "field2")
  }
}
