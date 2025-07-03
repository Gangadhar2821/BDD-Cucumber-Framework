@Cases @Regression @UI
Feature: 
  Manage Tasks
  
  As a CRM user
  I want to manage my Cases

  @AddCase @Regression
  Scenario: Add a New Case and Verify the Case is listed
    Given The user is on the HomePage
    When the user navigates to the cases Page
    And user clicks on the Create button
    And fills in all the required Case details
    And save the details
    Then the Case should  appear in the Cases list
