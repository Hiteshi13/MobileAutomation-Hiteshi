package test.java.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonClass;

public class LeaguesSteps extends CommonClass {

  @Given("user navigates to the {string} page")
  public void user_navigates_to_the_page(String pageName) {
    // navigating to Leagues page
    if (pageName.equals("Leagues")) {
      leaguesPage.navigationLeaguesButton.click();
    }
  }

  @When("user navigates to the {string} new page")
  public void user_navigates_to_the_new_page(String leagueName) {
    // navigating to League Name page
    welcomePage.selectFavourite(leagueName);
  }

  @And("user verifies the {string} page is displayed correctly")
  public void user_verifies_the_page_is_displayed_correctly(String leagueName) {
    // verify league name is displayed correctly
    Assert.assertTrue(leaguesPage.titleText.getText().contains(leagueName));
  }

  @And("user taps on the {string} sub-tab for {string}")
  public void user_taps_on_the_sub_tab_for(String subTab, String leagueName) {
    // verify sub tab for league name is selected and tapped correctly
    System.out.println("Navigating to the sub-tab: " + subTab + " for league: " + leagueName);
    Assert.assertTrue(
        "The league page displayed is incorrect",
        leaguesPage.titleText.getText().contains(leagueName));
    leaguesPage.selectSubTab(subTab);
  }

  @Then("user is displayed {string} correctly with the relevant {string}")
  public void user_is_displayed_correctly_with_the_relevant(
      String expectedSubTab, String expectedLeagueName) {
    // verify sub tab contains relevant league name and expected sub tab for example Standings or
    // Leaders
    String actualLeagueName = leaguesPage.titleText.getText();
    System.out.println(actualLeagueName);
    Assert.assertTrue(
        "Expected league name: " + expectedLeagueName + ", but found: " + actualLeagueName,
        actualLeagueName.contains(expectedLeagueName));

    String actualSubTab = leaguesPage.getCurrentSubTabName();
    System.out.println(actualSubTab);
    Assert.assertEquals(
        "Expected sub-tab: " + expectedSubTab + ", but found: " + actualSubTab,
        actualSubTab,
        expectedSubTab);
  }

  @And("user clicks on back navigation")
  public void user_clicks_on_back_navigation() {
    // click on back navigation
    leaguesPage.backNavigation.click();
  }

  @And("user is returned to {string} page correctly")
  public void user_is_returned_to_page_correctly(String pageName) {
    // verify tapping on back navigation lands on correct page i.e leagues
    String actualPageTitle = leaguesPage.titleText.getText();
    Assert.assertTrue(
        "Expected to be on the " + pageName + " page, but found: " + actualPageTitle,
        actualPageTitle.contains(pageName));
  }
}
