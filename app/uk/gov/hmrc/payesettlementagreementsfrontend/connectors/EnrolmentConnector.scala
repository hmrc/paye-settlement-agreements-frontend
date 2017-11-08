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

import javax.inject.Inject

import uk.gov.hmrc.http.{HeaderCarrier, HttpPost, HttpResponse}
import uk.gov.hmrc.payesettlementagreementsfrontend.FrontendAppConfig
import uk.gov.hmrc.payesettlementagreementsfrontend.models.ReferenceNumber
import uk.gov.hmrc.payesettlementagreementsfrontend.models.requests.EnrolmentRequest
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

class EnrolmentConnector @Inject()(httpPost: HttpPost,config: FrontendAppConfig) {
  def enrol(enrolmentRequest: EnrolmentRequest)(implicit hc: HeaderCarrier): Future[Either[String, ReferenceNumber]] = {

    lazy val uri = s"${config.psaBaseUrl}/enrol"

    val response: Future[HttpResponse] = httpPost.POST[EnrolmentRequest, HttpResponse](uri, enrolmentRequest)
    response.map(f =>
      f.status match {
        case 202 => {
          Right(f.json.as[ReferenceNumber])
        }
      }
    )
  }

}
