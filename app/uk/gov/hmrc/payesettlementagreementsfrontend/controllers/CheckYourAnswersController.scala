package uk.gov.hmrc.payesettlementagreementsfrontend.controllers

import com.google.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.actions.{AuthAction, DataRequiredAction, DataRetrievalAction}
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.CheckYourAnswersHelper
import uk.gov.hmrc.payesettlementagreementsfrontend.viewmodels.AnswerSection
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.check_your_answers
import uk.gov.hmrc.payesettlementagreementsfrontend.FrontendAppConfig
import uk.gov.hmrc.play.bootstrap.controller.FrontendController

class CheckYourAnswersController @Inject()(appConfig: FrontendAppConfig,
                                           override val messagesApi: MessagesApi,
                                           authenticate: AuthAction,
                                           getData: DataRetrievalAction,
                                           requireData: DataRequiredAction) extends FrontendController with I18nSupport {

  def onPageLoad() = (authenticate andThen getData andThen requireData) {
    implicit request =>
      val checkYourAnswersHelper = new CheckYourAnswersHelper(request.userAnswers)
      val sections = Seq(AnswerSection(None, Seq()))
      Ok(check_your_answers(appConfig, sections))
  }
}
