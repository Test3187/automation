

Feature: Login feature

  Scenario: Valid login
    Given I open "http://172.16.1.208:780/"
    When I enter username shaila and password shsu0001
    Then I should see homepage