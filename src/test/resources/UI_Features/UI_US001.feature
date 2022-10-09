Feature: UI_US001

  @demo
  @ui
  Scenario: Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given Medunna ana sayfasina gider
    And Ana sayfa giris ikonuna tiklar
    And Register butonuna tiklar
    And SSN kutusuna uygun ssn girer
    Then Hata mesajinin cikmadigini test eder