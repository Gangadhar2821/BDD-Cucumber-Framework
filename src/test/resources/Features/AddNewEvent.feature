@Events @Regression @UI
Feature: 
  Manage Events
  
  As a CRM user
  I want to manage my Events
  So that I can organize events and Schedule them efficiently

 @AddEvent @Regression
  Scenario: 
    Add New Event and validate it is listed

    Given The User is on HomePage
    And The user navigates to the Calender Page
    And The user click on Create button
    And The user fills in all the required fields
    And The user saves the Event
    Then The Event should be add to the Event list
