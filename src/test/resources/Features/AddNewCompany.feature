@Companies @Regression @UI
Feature: 
  Manage Companies
  
  As a CRM user
  I want to manage my companies
  So that I can organize Company information efficiently

  @AddCompany @Smoke
  Scenario: Add a New Company and Verify the Company is listed
    Given The User is on the Home Page
    When The User navigates to the Companies Page
    And User Clicks on the Create button
    And fills all the required company details
    And saves the form
    Then The comapany should  appear in the company list
