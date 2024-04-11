@leagues
Feature: User is successfully able to get stats and navigate back to Leagues page

  Scenario Outline: Navigate and verify league pages, interact with sub-tabs, and perform specific actions

    #User navigates to leagues page and verifies that correct page is displayed
    Given user navigates to the "Leagues" page
    When user navigates to the "<LeagueName>" new page
    And user verifies the "<LeagueName>" page is displayed correctly

    #user taps on sub-tab and verifies the correct leaguename is displayed on sub-tab
    And user taps on the "<SubTab>" sub-tab for "<LeagueName>"
    Then user is displayed "<SubTab>" correctly with the relevant "<LeagueName>"

    #user clicks on back navigation and verifies that they are returned to Leagues page correctly
    And user clicks on back navigation
    And user is returned to "Leagues" page correctly

    Examples:
      | LeagueName | SubTab    |
      | NBA        | STANDINGS |
      | NBA        | LEADERS   |

