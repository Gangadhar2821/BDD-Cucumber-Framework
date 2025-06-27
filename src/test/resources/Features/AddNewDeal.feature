@Deals @Regession @UI
Feature: 
  Manage Deals
  
  As a CRM user
  I want to manage my Deals
  So that I can setup deals efficiently

  @AddDeal @Regression
  Scenario: 
    Add a new Deal and validate it is listed

    Given The user is on HomePage
    And The User navigates to Deals Page
    And The User click on Create button
    And The User fills in all the required Deal details
    And The User saves the Deal
    Then The Deals should appear in the Deals list
