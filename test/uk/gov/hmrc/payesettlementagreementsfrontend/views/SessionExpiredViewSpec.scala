package uk.gov.hmrc.payesettlementagreementsfrontend.views

import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.ViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.session_expired

class SessionExpiredViewSpec extends ViewBehaviours {

  def view = () => session_expired(frontendAppConfig)(fakeRequest, messages)

  "Session Expired view" must {

    behave like normalPage(view, "session_expired", "guidance")
  }
}
