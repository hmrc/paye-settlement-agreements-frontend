package uk.gov.hmrc.payesettlementagreementsfrontend

import javax.inject.{Inject, Singleton}

import play.api.mvc.Call
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.routes
import uk.gov.hmrc.payesettlementagreementsfrontend.identifiers._
import uk.gov.hmrc.payesettlementagreementsfrontend.models.{CheckMode, Mode, NormalMode}
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.UserAnswers

@Singleton
class Navigator @Inject()() {

  private val routeMap: Map[Identifier, UserAnswers => Call] = Map(

  )

  private val editRouteMap: Map[Identifier, UserAnswers => Call] = Map(

  )

  def nextPage(id: Identifier, mode: Mode): UserAnswers => Call = mode match {
    case NormalMode =>
      routeMap.getOrElse(id, _ => routes.IndexController.onPageLoad())
    case CheckMode =>
      editRouteMap.getOrElse(id, _ => routes.CheckYourAnswersController.onPageLoad())
  }
}
