
Feature: Test Product add and Delete

  Scenario: Product Add to cart and verify into cart and Delete that product
    Given User is already having URL of Auto Application
    And sort dresses by Evening dress, large and dressy
    And verify dress name and price
    When clicks on Add to cart
    And verify that added product is correct 
    Then Delete added product
    And Verify that product is deleted



