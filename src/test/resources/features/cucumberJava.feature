Feature: As a user I want to add a new computer to computer database website

#  @smokeCICD
#  Scenario: Login functionality exists
#    Given I have open the browser
#    When I open Facebook website
#    Then Login button should exits

  Scenario: Add a computer
    Given I have open the "chrome" browser
    When I open Computer database website
    When I click add button
    When I fill computer details
    Then I should be able to add a computer

  Scenario: Add a computer
    Given I have open the "firefox" browser
    When I open Computer database website
    When I click add button
    When I fill computer details
    Then I should be able to add a computer