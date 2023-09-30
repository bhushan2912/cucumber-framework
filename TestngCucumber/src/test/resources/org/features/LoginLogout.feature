#Author: bhushan.patil@testbook.com
@Smoke
Feature: User Login and Logout from skill academy page

  @Sanity
  Scenario Outline: Login using a number from skill academy page and logout from skill academy page
  Given User is on testbook landing page
  And User clicks on skillAcademy page
  	And User is on skillAcademy page
  When User logged in with login number <mobileNumber>
  When User is on skillAcademy page in logged in state
  Then User is loggedout
  
  	Examples:
  | mobileNumber |
  | '6333843813' |
  | '6333523666' |
  
  
  @Smoke
  Scenario Outline: Login using from course page and logout
    Given User is on testbook landing page
    And User is navigate to <slug> course and <courseType> and <ExpectedCourseName>
    When User logged in with login number <mobileNumber>
    When User is on course page in logged in state
    Then User is loggedout

    Examples: 
      | slug                                    | courseType   | mobileNumber | ExpectedCourseName                      |
      | 'server-side-programming-with-node-js'  | 'selfPaced'  | '6333518434' | 'Server Side Programming with Node.js'  |
      | 'full-stack-development-career-program' | 'liveCourse' | '6333982944' | 'Full Stack Development Career Program' |
