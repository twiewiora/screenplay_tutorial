Feature: User logs in

  Background:
    Given User has an account

  @auth
  Scenario: User can log in using mail and password
    Given User is on Login page
    When he enters correct mail and password
    Then he is logged in

  @project
  Scenario: User can create a project
    Given User is on Main page
    When he creates a new project
    Then the project is created

  @task
  Scenario: User can add task to the project
    Given User has the project created
    And User is on Main page
    When he creates new task in the project
    Then the task is correctly created
