package uk.gov.hmrc.payesettlementagreementsfrontend

import play.api.mvc.Call
import uk.gov.hmrc.payesettlementagreementsfrontend.identifiers.Identifier
import uk.gov.hmrc.payesettlementagreementsfrontend.models.{Mode, NormalMode}
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.UserAnswers

class FakeNavigator(desiredRoute: Call, mode: Mode = NormalMode) extends Navigator {
  override def nextPage(controllerId: Identifier, mode: Mode): (UserAnswers) => Call = (ua) => desiredRoute
}
