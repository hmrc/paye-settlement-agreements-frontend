package uk.gov.hmrc.payesettlementagreementsfrontend.controllers.$pluralName;format="lower"$

import javax.inject.Inject

import play.api.data.Form
import play.api.i18n.{I18nSupport, MessagesApi}
import uk.gov.hmrc.play.bootstrap.controller.FrontendController
import uk.gov.hmrc.payesettlementagreementsfrontend.connectors.DataCacheConnector
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.actions._
import uk.gov.hmrc.payesettlementagreementsfrontend.{FrontendAppConfig, Navigator}
import uk.gov.hmrc.payesettlementagreementsfrontend.forms.BooleanForm
import uk.gov.hmrc.payesettlementagreementsfrontend.identifiers.{$pluralName$Id, Delete$className$Id}
import uk.gov.hmrc.payesettlementagreementsfrontend.models.{Mode, $className$}
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.UserAnswers
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.$pluralName;format="lower"$.delete$className$

import scala.concurrent.Future

class Delete$className;format="cap"$Controller @Inject()(appConfig: FrontendAppConfig,
                                                  override val messagesApi: MessagesApi,
                                                  dataCacheConnector: DataCacheConnector,
                                                  navigator: Navigator,
                                                  authenticate: AuthAction,
                                                  getData: DataRetrievalAction,
                                                  requireData: DataRequiredAction) extends FrontendController with I18nSupport {

  def onPageLoad(index: Int, mode: Mode) = (authenticate andThen getData andThen requireData) {
    implicit request =>
      request.userAnswers.$pluralName;format="decap"$.flatMap(x => x.lift(index)) match {
        case None => NotFound
        case Some($className;format="decap"$) => Ok(delete$className$(index, $className;format="decap"$, appConfig, BooleanForm(), mode))
      }
  }

  def onSubmit(index: Int, mode: Mode) = (authenticate andThen getData andThen requireData).async {
    implicit request =>
      request.userAnswers.$pluralName;format="decap"$.flatMap(x => x.lift(index)) match {
        case None => Future.successful(NotFound)
        case Some($className;format="decap"$) =>
          BooleanForm().bindFromRequest().fold(
            (formWithErrors: Form[Boolean]) =>
              Future.successful(BadRequest(delete$className$(index, $className;format="decap"$, appConfig, formWithErrors, mode))),
            (value) =>
              if (value) {
              dataCacheConnector.removeFromCollection[$className$](request.externalId, $pluralName$Id.toString, $className;format="decap"$).map(cacheMap =>
                Redirect(navigator.nextPage(Delete$className$Id, mode)(new UserAnswers(cacheMap))))
              } else {
                Future.successful(Redirect(navigator.nextPage(Delete$className$Id, mode)(request.userAnswers)))
              }
          )
      }
  }
}
