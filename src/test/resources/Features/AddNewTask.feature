@Tasks @Regression @UI
Feature: 
  Manage Tasks
  
  As a CRM user
  I want to manage my Tasks
  So I can assign them Accordingly

  @AddTask @Regression
  Scenario: Add a New Task and Verify the Task is listed
    Given The User is on the HomePage
    When The User navigates to the Tasks Page
    And User clicks on the Create button
    And fills all the required task details
    And save the form
    Then The Task should  appear in the Tasks list
