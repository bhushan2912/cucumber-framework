Feature: Testing Orange HRM application

  Scenario: Testing Orange HRM login functionality
    Given User is already having URL
    And also having username and password
    When User enter the username and password
    And clicks on login button
    Then close the browser

  Scenario Outline: Testing Orange HRM login functinality for <user><username><password>
    Given User is already having appliction URL as <url>
    And Also having username as <username> and password as <password> for the application
    When User enter the username and password
    And clicks on login button
    Then close the browser

    Examples: 
      | user    | url                                        | username | password  |
      | valid   | https://opensource-demo.orangehrmlive.com/ | Admin    | admin123  |
      | invalid | https://opensource-demo.orangehrmlive.com/ | admin12  | manager   |
      | invalid | https://opensource-demo.orangehrmlive.com/ | admin    | manager23 |
