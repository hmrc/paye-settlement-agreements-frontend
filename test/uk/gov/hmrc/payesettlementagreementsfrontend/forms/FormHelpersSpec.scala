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

package uk.gov.hmrc.payesettlementagreementsfrontend.forms

import play.api.data.Form
import play.api.data.Forms.single
import uk.gov.hmrc.payesettlementagreementsfrontend.utils.FormHelpers
import uk.gov.hmrc.play.test.UnitSpec

class FormHelpersSpec extends UnitSpec {
  "Form Helper" must {

    object TestForm extends WithRequiredBooleanMapping {
      def apply(): Form[Boolean] = Form(
        single(
          "element" -> requiredBoolean
        )
      )
    }

    "return no error" when {
      "the key is not found" in {
        val form = TestForm().bind(Map("element" -> "test"))

        FormHelpers.getErrorByKey(form,"unkownError") shouldBe ""
      }
    }

    "return the apropriate error" when {
      "the right key is provided" in {
        val form = TestForm().bind(Map("element" -> "not allowed"))

        FormHelpers.getErrorByKey(form,"element") shouldBe "error.boolean"
      }
    }
  }
}
