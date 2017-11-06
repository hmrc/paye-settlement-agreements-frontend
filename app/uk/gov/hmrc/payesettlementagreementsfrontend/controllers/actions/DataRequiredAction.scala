package uk.gov.hmrc.payesettlementagreementsfrontend.controllers.actions

import com.google.inject.{ImplementedBy, Inject}
import play.api.mvc.{ActionRefiner, Result}
import play.api.mvc.Results.Redirect
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.routes
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.UserAnswers
import uk.gov.hmrc.payesettlementagreementsfrontend.models.requests.{DataRequest, OptionalDataRequest}
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.HeaderCarrierConverter

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class DataRequiredActionImpl @Inject() extends DataRequiredAction {

  override protected def refine[A](request: OptionalDataRequest[A]): Future[Either[Result, DataRequest[A]]] = {
    implicit val hc = HeaderCarrierConverter.fromHeadersAndSession(request.headers, Some(request.session))

    request.userAnswers match {
      case None => Future.successful(Left(Redirect(routes.SessionExpiredController.onPageLoad())))
      case Some(data) => Future.successful(Right(DataRequest(request.request, request.externalId, data)))
    }
  }
}

@ImplementedBy(classOf[DataRequiredActionImpl])
trait DataRequiredAction extends ActionRefiner[OptionalDataRequest, DataRequest]
