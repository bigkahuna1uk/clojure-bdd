Feature: Addition
  In order to avoid silly mistakes
  As a math idiot
  I want to be told the division of two numbers

  Scenario: Divide two numbers
    Given I have entered 30 into the calculator
    And I have entered 10 into the calculator
    When I press divide
    Then the result should be 3 on the screen


  Scenario: Divide multiple numbers
    Given I have entered 30 into the calculator
    And I have entered 10 into the calculator
    And I have entered 3 into the calculator
    When I press divide
    Then the result should be 1 on the screen


  Scenario: Divide does nothing if only one parameter present
    Given I have entered 70 into the calculator
    When I press divide
    Then the result should be 70 on the screen