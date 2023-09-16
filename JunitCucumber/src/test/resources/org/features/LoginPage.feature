Feature: Actitime Login Feature

@Smoke @Regression
Scenario: ActiTime Login Page title
Given User is on the login page
When User gets the title of the page
Then Title of login page should be "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"

@Regression
Scenario: ActiTime Login Test Case
Given User is on the login page
When User enters username and password
And User clicks on login button
Then My Account label is displayed