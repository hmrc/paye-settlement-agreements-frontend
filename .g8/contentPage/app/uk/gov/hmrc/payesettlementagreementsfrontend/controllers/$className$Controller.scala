package uk.gov.hmrc.payesettlementagreementsfrontend.controllers

import javax.inject.{Inject, Singleton}

import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent}
import uk.gov.hmrc.play.bootstrap.controller.FrontendController
import uk.gov.hmrc.payesettlementagreementsfrontend.FrontendAppConfig
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.actions.{DataRequiredAction, DataRetrievalAction}
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.$className;format="decap"$

@Singleton
class $className$Controller @Inject()(val appConfig: FrontendAppConfig,
                                      val messagesApi: MessagesApi,
                                      getData: DataRetrievalAction,
                                      requireData: DataRequiredAction) extends FrontendController with I18nSupport {

  def onPageLoad: Action[AnyContent] = (getData andThen requireData) { implicit request =>
    Ok($className;format="decap"$(appConfig))
  }
}
