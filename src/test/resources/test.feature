Feature: Employee
  Scenario: Receive all employees
    When User gets all employees
    Then Returned JSON object contains 2 entry/entries
  Scenario: Receive single employee
    When User gets one employee with id 1
    Then Returned JSON object contains 1 entry/entries
  Scenario: Receive employee that does not exist
    When User gets one employee with id 99999
    Then 404 is returned