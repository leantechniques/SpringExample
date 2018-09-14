Feature: Testing Cucumber

Scenario: Finding user from ID
    Given user is added to database
    When user ID is searched
    Then program should return a JSON