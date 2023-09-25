Feature: Testing Vtiger web application with add new contact and delete newly added contact

  Background: Gets Contact Page by URL Username and Password
    Given User is already having application URL of vtiger
    And User is already having login credentials
      | username | password |
      | admin    | Test@123 |
    When user enter the username and password for vtiger
    And clicks on login button for vtiger
    Then user gets contacts page

  Scenario: New contact add in vtiger application
    Given user clicks on add contacts button
    When user create contact with 'Bhushan','Patil','9785426223'
    Then user validate that new contact created or not
    And user clicks on logout button and close the window

  Scenario: New created contact delete in vtiger application
    Given select check box of created contact
    When delete selected contact
    Then user validate that contact is deleted or not
    And user clicks on logout button and close the window
