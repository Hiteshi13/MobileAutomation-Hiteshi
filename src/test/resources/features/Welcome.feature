@welcome
Feature: Guest User lands on Welcome page and selects favourite League and Teams

  Scenario Outline: Guest User is successfully able to navigate to selected favourite league and teams

    #Landing Page - Welcome page
    Given user is displayed the welcome page
    When user clicks on the "Get Started" button

    #User verifies correct page is displayed and selects favourite leagues
    And user lands on "Choose your favorite leagues" page
    And user selects the following leagues
      | League    |
      | <League1> |
      | <League2> |
    And user presses the "Continue" button
    And user is on allow location popup and clicks on Later option

    #User verifies correct page is displayed and selects favourite teams
    And user lands on "Choose your favorite teams" page
    When user selects teams as follows
      | League    | Team    |
      | <League1> | <Team1> |
      | <League2> | <Team2> |
    And user presses the "Continue" another button
    And user lands on "Never miss a game" page
    And user presses "Done"
    Then user lands on home page
    And user is displayed theScore Bet app popup
    And user closes the pop-up

    Examples:
      | League1    | League2      | Team1               | Team2           |
      | NHL Hockey | NFL Football | Toronto Maple Leafs | Toronto Raptors |

