#This is authentication feature of the application

Feature: Login

@selenium
Scenario: Valid admin Login
Given I nvaigate to login page
When I enter "admin" as username
And I enter "manager" as password
And I click on login button
Then I should see home page

@selenium
Scenario: Valid trainee Login
Given I nvaigate to login page
When I enter "trainee" as username
And I enter "trainee1" as password
And I click on login button
Then I should see home page