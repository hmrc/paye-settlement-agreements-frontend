package uk.gov.hmrc.payesettlementagreementsfrontend.controllers

import play.api.test.Helpers._
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.index

class IndexControllerSpec extends ControllerSpecBase {

  "Index Controller" must {
    "return 200 for a GET" in {
      val result = new IndexController(frontendAppConfig, messagesApi).onPageLoad()(fakeRequest)
      status(result) mustBe OK
    }

    "return the correct view for a GET" in {
      val result = new IndexController(frontendAppConfig, messagesApi).onPageLoad()(fakeRequest)
      contentAsString(result) mustBe index(frontendAppConfig)(fakeRequest, messages).toString
    }
  }
}
