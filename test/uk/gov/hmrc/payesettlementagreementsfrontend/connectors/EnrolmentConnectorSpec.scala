/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.payesettlementagreementsfrontend.connectors
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import play.api.libs.json.Json
import uk.gov.hmrc.http.{HeaderCarrier, HttpPost, HttpResponse}
import uk.gov.hmrc.payesettlementagreementsfrontend.FrontendAppConfig
import uk.gov.hmrc.payesettlementagreementsfrontend.models.ReferenceNumber
import uk.gov.hmrc.payesettlementagreementsfrontend.models.requests.EnrolmentRequest
import uk.gov.hmrc.play.test.UnitSpec

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class EnrolmentConnectorSpec extends UnitSpec with MockitoSugar {
  "Enrolment connector" must {
    "return succesful call" when {
      "we call the enrolment endpoint on our backend" in {
        when {
          httpPost.POST[EnrolmentRequest, HttpResponse](any(), any(), any())(any(),any(),any(),any())
        } thenReturn {
          Future.successful(HttpResponse(202, Some(Json.toJson(ReferenceNumber("XA234282349")))))
        }

        val result = Await.result(enrolmentConnector.enrol(EnrolmentRequest("Test Request")),Duration.Inf)
        result shouldBe Right(ReferenceNumber("XA234282349"))
      }
    }
  }

  implicit val hc = HeaderCarrier()
  val httpPost = mock[HttpPost]
  val config = mock[FrontendAppConfig]
  val enrolmentConnector = new EnrolmentConnector(httpPost,config)
}
