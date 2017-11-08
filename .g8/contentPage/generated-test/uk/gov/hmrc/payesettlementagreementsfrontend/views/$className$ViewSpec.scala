package uk.gov.hmrc.payesettlementagreementsfrontend.views

import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.ViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.$className;format="decap"$

class $className$ViewSpec extends ViewBehaviours {

  def view = () => $className;format="decap"$(frontendAppConfig)(fakeRequest, messages)

  "$className$ view" must {

    behave like normalPage(view, "$className;format="decap"$")
  }
}
