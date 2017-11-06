package uk.gov.hmrc.payesettlementagreementsfrontend.views

import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.ViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.index

class IndexViewSpec extends ViewBehaviours {

  def view = () => index(frontendAppConfig)(fakeRequest, messages)

  "Index view" must {

    behave like normalPage(view, "index", "guidance")
  }
}
