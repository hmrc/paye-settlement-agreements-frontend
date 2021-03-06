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

package uk.gov.hmrc.payesettlementagreementsfrontend.views

import uk.gov.hmrc.payesettlementagreementsfrontend.views.behaviours.ViewBehaviours
import uk.gov.hmrc.payesettlementagreementsfrontend.views.html.error_template

class ErrorPageSpec extends ViewBehaviours {
  def view = () => error_template("error.title","error.heading","error.guidance",frontendAppConfig)(fakeRequest,messages)

  "Error view" must {
    behave like normalPage(view,"error","guidance")
  }

}
