Feature: Tasks Page Feature

Background:
Given User has already logged in to application
|username|password|
|USERNAME|PASSWORD|

Scenario: Dashboard page title
Given User is on dashboard page
When User gets the title of the page
Then Page title should be "actiTIME -  Enter Time-Track"

Scenario: Dashboard page tabs
Given User is on dashboard page
Then User gets dashboard
|TIME-TRACK|
|TASKS|
|REPORTS|
|USERS|
And Tabs count should be 4