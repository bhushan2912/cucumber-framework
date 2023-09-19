Feature: Tasks Page Feature

Scenario: Actitime login and validation
Given User has already logged in to application
|username|password|
|admin|manager|
When User is on dashboard page
Then User gets the title of the page
Then Page title should be 'actiTIME - Enter Time-Track'
Then User gets dashboard
|Time-Track|
|Tasks|
|Reports|
|Users|
And Tabs count should be 4

