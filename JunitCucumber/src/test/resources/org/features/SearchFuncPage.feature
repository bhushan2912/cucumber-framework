Feature: Flipkart Search Functionality Feature

@Regression
Scenario: ActiTime Login Test Case
Given User is on the login page
When User enters username and password
And User clicks on login button
Then My Account label is displayed
When Enter search text as "samsung m32"
And Clicks on Search button
Then Search should display the result for "SAMSUNG M32 5G (Sky blue, 128 GB)"
