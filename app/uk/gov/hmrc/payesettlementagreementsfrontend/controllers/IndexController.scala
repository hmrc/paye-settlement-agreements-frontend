package uk.gov.hmrc.payesettlementagreementsfrontend.controllers

import javax.inject.{Inject, Singleton}

import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent}
import uk.gov.hmrc.play.bootstrap.controller.FrontendController
import uk.gov.hmrc.payesettlementagreementsfrontend.FrontendAppConfig
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.index

@Singleton
class IndexController @Inject()(val appConfig: FrontendAppConfig,
                                val messagesApi: MessagesApi) extends FrontendController with I18nSupport {

  def onPageLoad: Action[AnyContent] = Action { implicit request =>
    Ok(index(appConfig))
  }
}
