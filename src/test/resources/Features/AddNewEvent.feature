Feature: 
  Add the New Event in Cogmento CRM Portal

  Scenario: 
    Create a new event and verify it appears on the calendar

    Given the user is on the Home Page
    When the user clicks the Calendar icon from the main menu
    And the user clicks the Create Event button
    And the user enters data in all mandatory fields
    And the user clicks the Save button
    Then the user should be navigated to the Event details page
    And the user should see the event displayed in the Calendar
