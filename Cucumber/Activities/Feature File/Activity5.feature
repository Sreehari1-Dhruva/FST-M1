@activity5
Feature: Data Driven test with Examples

  @loginTest
  Scenario Outline: Testing with correct data from inputs
    Given the user is on the login page
    When the user enters "<usernames>" and "<passwords>"
    And clicks the submit button
    Then verify error message as "Invalid credentials"

    Examples:
      | usernames  | passwords     |
      | wrongAdmin | password      |
      | admin      | wrongPassword |
      | !@@$!@$    | $##@#!@$!     |
      | 212        | 4678          |
