Feature: User logs in

  Scenario: User can log in using mail and password
    Given Adam has an account
    And he is on Login page
    When he enters correct mail and password
    Then he is logged in
