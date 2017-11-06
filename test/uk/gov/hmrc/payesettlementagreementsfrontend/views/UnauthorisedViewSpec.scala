package uk.gov.hmrc.payesettlementagreementsfrontend.views

import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.ViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.unauthorised

class UnauthorisedViewSpec extends ViewBehaviours {

  def view = () => unauthorised(frontendAppConfig)(fakeRequest, messages)

  "Unauthorised view" must {

    behave like normalPage(view, "unauthorised")
  }
}
