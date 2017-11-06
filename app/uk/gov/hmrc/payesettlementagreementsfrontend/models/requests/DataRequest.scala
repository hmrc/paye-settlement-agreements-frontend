package uk.gov.hmrc.payesettlementagreementsfrontend.models.requests

import play.api.mvc.{Request, WrappedRequest}
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.UserAnswers

case class OptionalDataRequest[A] (request: Request[A], externalId: String, userAnswers: Option[UserAnswers]) extends WrappedRequest[A](request)

case class DataRequest[A] (request: Request[A], externalId: String, userAnswers: UserAnswers) extends WrappedRequest[A](request)
