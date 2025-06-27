@Contacts @Regression @UI
Feature: 
  Manage Contacts
  
  As a CRM user
  I want to manage my contacts
  So that I can organize customer information efficiently

  @AddContact @Smoke
  Scenario: Add a new contact and validate it is listed
    Given the user is on the Home page
    When the user navigates to the Contacts page
    And clicks on the Create button
    And fills in all the required contact details
    And submits the form
    Then the new contact should appear in the contact list
