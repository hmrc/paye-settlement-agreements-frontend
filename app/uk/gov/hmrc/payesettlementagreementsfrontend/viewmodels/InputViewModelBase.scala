package uk.gov.hmrc.payesettlementagreementsfrontend.viewmodels

trait InputViewModelBase {
  val id: String
  def errorKey: String
  def value: Option[String]
}
