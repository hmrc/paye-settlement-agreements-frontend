package uk.gov.hmrc.payesettlementagreementsfrontend.controllers.$pluralName;format="lower"$

import javax.inject.Inject

import play.api.data.Form
import play.api.i18n.{I18nSupport, MessagesApi}
import uk.gov.hmrc.play.bootstrap.controller.FrontendController
import uk.gov.hmrc.payesettlementagreementsfrontend.connectors.DataCacheConnector
import uk.gov.hmrc.payesettlementagreementsfrontend.controllers.actions._
import uk.gov.hmrc.payesettlementagreementsfrontend.{FrontendAppConfig, Navigator}
import uk.gov.hmrc.payesettlementagreementsfrontend.forms.$className$Form
import uk.gov.hmrc.payesettlementagreementsfrontend.identifiers.{Edit$className$Id, $pluralName$Id}
import uk.gov.hmrc.payesettlementagreementsfrontend.models.{Mode, $className$}
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.UserAnswers
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.$pluralName;format="lower"$.edit$className$

import scala.concurrent.Future

class Edit$className;format="cap"$Controller @Inject()(appConfig: FrontendAppConfig,
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
        case Some($className;format="decap"$) => Ok(edit$className$(index, appConfig, $className$Form().fill($className;format="decap"$), mode))
      }
  }

  def onSubmit(index: Int, mode: Mode) = (authenticate andThen getData andThen requireData).async {
    implicit request =>
      request.userAnswers.$pluralName;format="decap"$.flatMap(x => x.lift(index)) match {
        case None => Future.successful(NotFound)
        case Some($className;format="decap"$) =>
          $className$Form().bindFromRequest().fold(
            (formWithErrors: Form[$className$]) =>
              Future.successful(BadRequest(edit$className$(index, appConfig, formWithErrors, mode))),
            (value) =>
              dataCacheConnector.replaceInCollection[$className$](request.externalId, $pluralName$Id.toString, index, value).map(cacheMap =>
                Redirect(navigator.nextPage(Edit$className$Id, mode)(new UserAnswers(cacheMap)))
              )
          )
      }
  }
}
