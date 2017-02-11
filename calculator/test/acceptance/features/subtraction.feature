Feature: Subtraction
  In order to avoid silly mistakes
  As a math idiot
  I want to be told the subtraction of two numbers

  Scenario: Subtract two numbers
    Given I have entered 70 into the calculator
    And I have entered 50 into the calculator
    When I press subtract
    Then the result should be 20 on the screen


  Scenario: Subtract multiple numbers
    Given I have entered 70 into the calculator
    And I have entered 50 into the calculator
    And I have entered 20 into the calculator
    When I press subtract
    Then the result should be 0 on the screen


  Scenario: Subtraction negates if only one parameter present
    Given I have entered 70 into the calculator
    When I press subtract
    Then the result should be -70 on the screen