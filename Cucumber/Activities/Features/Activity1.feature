@activity1
Feature: First Test
 
 @scenario1
  Scenario: Opening a webpage using Selenium
    Given User is on the Google homepage
    When they type Cheese and hits ENTER
    Then it should show how many Search results were found
