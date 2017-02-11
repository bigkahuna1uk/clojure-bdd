Feature: Multiplication
  In order to avoid silly mistakes
  As a math idiot
  I want to be told the multiplication of two or more numbers

  Scenario: Multiply two numbers
    Given I have entered 50 into the calculator
    And I have entered 70 into the calculator
    When I press multiply
    Then the result should be 3500 on the screen


  Scenario: Multiply more than one number
    Given I have entered 2 into the calculator
    And I have entered 4 into the calculator
    And I have entered 6 into the calculator
    When I press multiply
    Then the result should be 48 on the screen


  Scenario: Multiply does nothing if only one parameter present
    Given I have entered 70 into the calculator
    When I press multiply
    Then the result should be 70 on the screen