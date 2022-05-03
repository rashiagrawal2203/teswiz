@web
Feature: Swiggy Cart Test

  @cart
  Scenario: Validate the cart items
    Given I am on Home Page
    When  I set the location to "Bangalore"
    Then  I should see the list of restaurants on Swiggy Home Page
    When  I sort the restaurants by Rating and select "Domino's" in restaurants list
    And   I select the Food Item with Quantity as
      | Food Items             | Quantity |
      | "Pepsi Black Can"      | "1"      |
      | "Choco Lava Cake"      | "2"      |
      | "Crinkle Fries"        | "3"      |
    Then  I should be able to validate the cart details on listing page and checkout page
