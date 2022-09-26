Feature:

  @demo1
  Scenario: API kullanarak kayitli kisiler olusturun ve dogrulayin
    Given Kullanici kayit icin data olusturur
    And Kullanici kayit icin post request gonderir
    Then Kullanici API kayitlirini dogrular
