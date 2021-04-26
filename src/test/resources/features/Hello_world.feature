Feature: Hello world

  Scenario: First scenario

    Given I'm Tomek!
    And Hello World!

  Scenario: Variables

    Given String "variable"
    And Number value 13
    And Float value 3.14
    But any word may be a variable

    When simple string list
      | value1 |
      | value2 |
      | value3 |
    When another table
      | header1   | header2   | header3   |
      | value 1-1 | value 2-1 | value 2-1 |
      | value 1-2 | value 2-2 | value 2-2 |
    And one more table
      | header1 | value 1-1 | value 1-2 |
      | header2 | value 2-1 | value 2-2 |
      | header3 | value 3-1 | value 3-2 |
    And simple table
      | header1 | value 1-1 | value 1-2 |
      | header2 | value 2-1 | value 2-2 |
      | header3 | value 3-1 | value 3-2 |
    Then magic multilines string
    """
    umba umba
    kwa kwakwa
    umbaba
    """
