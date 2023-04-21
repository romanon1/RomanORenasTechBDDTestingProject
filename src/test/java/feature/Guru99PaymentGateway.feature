Feature: Payment Gateway functional test

  #Before you order the toy, you should create a scenario to verify Header
  #Here is the expected text “Mother Elephant With Babies Soft Toy”
  #You should use parametrization in this scenario




  Create a scenario that the URL should contain “payment-gateway”
  Scenario: Header verification before order
    Given the user want to visit Guru99
    Then the user want to check that URL contain “payment-gateway”