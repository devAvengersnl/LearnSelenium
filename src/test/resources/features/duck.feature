Feature: As a user I want to search facebook website on duckduckgo.com

#  @smokeCICD
#  Scenario: Login functionality exists
#    Given I have open the browser
#    When I open Facebook website
#    Then Login button should exits

  Scenario: Search Facebook website
    Given I have open the "chrome" browser
    When I open Duck Duck Go database website
    When I search for "facebook"
    And I click first link
    Then I should see facebook login page

  Scenario: Search Facebook website
    Given I have open the "firefox" browser
    When I open Duck Duck Go database website
    When I search for "facebook"
    And I click first link
    Then I should see facebook login page