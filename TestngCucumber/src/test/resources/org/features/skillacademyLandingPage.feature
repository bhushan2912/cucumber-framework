#Author: bhushan.patil@testbook.com
@Smoke
Feature: User Login and Logout from skill academy page 

  @Smoke
  Scenario: Login using a number from skill academy page and logout from skill academy page
    Given User is on testbook landing page 'https://beta.testbook.com/'
    And User clicks on skillAcademy page
   	And User is on skillAcademy page
    When User logged in with login number '6333843813' and otp '428266' 
    When User is on skillAcademy page in logged in state
    Then User is loggedout

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
