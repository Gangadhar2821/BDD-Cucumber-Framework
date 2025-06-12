Feature: 
  Add the New Contact in Cogmento CRM portal

  Scenario: 
    Add the New Contact in Contacts Module and to Validate the Created Contact

    Given User is on the Home Page
    When User clicks on the Add Contacts icon from the main menu
    And User should be navigated to the Create New Contact page
    And User enters data in all mandatory fields
    And User Clicks on Save button
    Then Contact should be added to the list in the Contacts page