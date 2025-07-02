@NavigationMenus @Smoke @UI
Feature: 
  Manage NavigationMenu
  
  As a CRM user
  I want to manage my menus
  So as to facilitate easy Navigation to the Customers

  @MenusNav @Smoke
  Scenario: To Navigate through all the menus and test their functionality
    Given the user is on the Home page
    And user click on Home Icon
    And verifies the HomePage
    When the user click on the Calender icon
    And verifies the CalenderPage
    And the user click on Contact icon
    And verifies the Contact page
    And user click on Companies icon
    And user verifies the Companies Page
    And user click on Deals icon
    And user verifies the Deals Page
    And user click on Tasks icon
    And user verifies the Tasks Page
    And user click on Cases icon
    And user verifies the Cases Page
    And user click on Calls icon
    And user verifies the Calls Page
    And user click on Documents icon
    And user verifies the Documents Page
    And user click on Email icon
    And user verifies the Inbox Page
    And user click on Campaigns icon
    And user verifies the Campaigns Page
    And user click on Forms icon
    And user verifies the Forms Page
    And user click on Reports icon
    And user verifies the Reports Page
    And User click on Home Icon again
    Then The user should be able to return to the HomePage
