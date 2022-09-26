Feature: US1234


  Background:
    Given user connects to the database

  @demo
    Scenario: user verified number of student table rows
      Given user connects to the student table
      And print the total row count and verify

    Scenario: user verified first row in student table
      Given user connects to the student table
      And print first student name and verify

    Scenario: user verified last row in student table
      Given user connects to the student table
      And print last student name and verify

    Scenario: user verified spesific row in student table
      Given user connects to the student table
      And print spesific student name and verify