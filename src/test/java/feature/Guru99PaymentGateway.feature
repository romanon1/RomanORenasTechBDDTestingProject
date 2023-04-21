Feature: Payment Gateway functional test

  Background: Open Guru99 order page
    Given the user wants to visit Guru99 order page

  @TC1 @Smoke_Suite
  Scenario: Url verification
    When the user wants to check that URL contain "payment-gateway"

  @TC2 @Regression_Suite
  Scenario: Header verification
    When the user wants to check that URL contain "payment-gateway"
    Then the user wants to verify "Mother Elephant With Babies Soft Toy" header

  @TC3 @Regression_Suite
  Scenario: Price verification
    When the user wants to check that URL contain "payment-gateway"
    Then the user wants to verify "Mother Elephant With Babies Soft Toy" header
    And the user wants to verify that the toy price is "20"

  @TC4 @Regression_Suite
  Scenario: Verification whether the user can buy the product in the required quantity
    When the user wants to check that URL contain "payment-gateway"
    Then the user wants to verify "Mother Elephant With Babies Soft Toy" header
    And the user wants to verify that the toy price is "20"
    Then the user wants to choose "5" units of the product
    And the user wants to click on buy button
    Then The user wants to enter payment data as follows
      | Card Number      | 1234567890123456 |
      | Expiration Month | 11               |
      | Expiration Year  | 2026             |
      | CVV Code         | 189              |
    And the user wants to click on pay now button
    Then the user wants to verify a "Payment successfull!" message

  @TC5 @Smoke_Suite
  Scenario Outline: Verification whether the user can buy the product in the required quantity
    When the user wants to check that URL contain "payment-gateway"
    Then the user wants to verify "Mother Elephant With Babies Soft Toy" header
    And the user wants to verify that the toy price is "20"
    Then the user wants to choose certain "<Quantity>" of the product
    And the user wants to click on buy button
    Then The user wants to enter payment data as follows
      | Card Number      | 1234567890123456 |
      | Expiration Month | 11               |
      | Expiration Year  | 2026             |
      | CVV Code         | 189              |
    And the user wants to click on pay now button
    Then the user wants to verify a "Payment successfull!" message
    Examples:
      | Quantity |
      | 5        |
      | 8        |
      | 9        |
      | 2        |
      | 4        |
