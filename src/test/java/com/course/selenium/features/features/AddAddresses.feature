Feature: Adding address to My Account
  As a user
  I want to add new address to account
  So that I can book hotel

  Background:
    Given the user is on the HomePage

  @done
  Scenario: New address successfully added to My account
    Given the user is on the authentication page
    When the user types a random email into the create account email input
    And the user clicks on the create an account button
    And the user fills the required fields on the create account form
    And the user clicks the register button
    Then the user should be logged in their account page
    And the account page should display welcome message "Your account has been created."
    And the user clicks on My Addresses
    And the user clicks on Add a new address
    And the user fills the address form
    And the user clicks the Save button
    Then my addresses page should include the new address

