package uk.gov.hmrc.payesettlementagreementsfrontend.utils

import uk.gov.hmrc.payesettlementagreementsfrontend.SpecBase

class RadioOptionSpec extends SpecBase {

  "Radio Option" must {
    "build correctly from a key prefix and option" in {
      val radioOption = RadioOption("prefix", "option")
      radioOption.id mustBe "prefix.option"
      radioOption.value mustBe "option"
      radioOption.messageKey mustBe "prefix.option"
    }
  }
}
