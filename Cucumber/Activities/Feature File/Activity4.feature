@activity4
Feature: Data Driven test without Examples

  Scenario: Testing with correct data from inputs
    Given the user is on the login page
	When the user enters "admin" and "password"
	And clicks the submit button
	Then  verify message as "Welcome Back, Admin!"
