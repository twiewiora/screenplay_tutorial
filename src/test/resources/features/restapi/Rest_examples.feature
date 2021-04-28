Feature: Rest examples

  Background:
    Given User has an token

  @project
  Scenario: User creates project using rest

    When User creates new project using rest
    Then project is created by rest

  @task
  Scenario: User can add task to the project
    And User has a project created using rest

    When he adds a task to the project using rest
    Then task is created by rest
