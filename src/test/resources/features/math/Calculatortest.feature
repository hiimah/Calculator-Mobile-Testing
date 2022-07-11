@math @android
Feature: Verify Calculator

  Background:
    Given user is on login page
    And user input username "admin"
    And user input password "admin"
    And user click button login

  @input @Positive @CalculatorFunctionality
  Scenario Outline: Verify the basic function of the calculator
    When user input Numb1 is <Num1>
    And user choose operator "<Op>"
    And user input numb2 is <Num2>
    And user using operator2 <Op2>
    Then verify the operator3 <Total>
    Examples:
      | Num1 |  Op  | Num2 |  Op2  | Total |
      |  25  |  +   |  25  |   =   |   50  |
      |  70  |  -   |  30  |   =   |   40  |
      | 150  |  /   |  5   |   =   |   30  |
      |  5   |  *   |  4   |   =   |   20  |

  @Negative
  Scenario: user input Numb1 with special character
    When user input Numb1 is "^,^!"
    And user input numb2 is 2
    And user using operator2 =
    Then back to list app

  @Negative
  Scenario: user does not input field numb1 and numb2
    When user does not input all field
    And user using operator2 =
    Then back to list app

  @Negative
  Scenario: user input character on filed numb1 and numb2
    When user input Numb1 is "Angka"
    And user input numb2 is "Angka"
    And user using operator2 =
    Then back to list app



