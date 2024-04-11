package test.java.stepDefinition;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import utils.CommonClass;

public class WelcomeSteps extends CommonClass {

  @Given("user is displayed the welcome page")
  public void user_is_displayed_the_welcome_page() {
    // Verify the welcome text is displayed
    Assert.assertTrue("Welcome text is not displayed", welcomePage.welcomeTxt.isDisplayed());
  }

  @When("user clicks on the {string} button")
  public void user_clicks_on_the_button(String btnName) {
    // select favourite leagues
    welcomePage.selectFavourite(btnName);
  }

  @And("user lands on {string} page")
  public void user_lands_on_page(String page) {
    // user lands on favourite league or teams page
    MobileElement favoritePage = welcomePage.selectFavourite(page);
    Assert.assertTrue(page + "page not displayed", favoritePage.isDisplayed());
  }

  @And("user selects the following leagues")
  public void user_selects_the_following_leagues(io.cucumber.datatable.DataTable dataTable) {
    // used data table to read data for selecting multiple values for favourite leagues
    List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
    for (Map<String, String> row : rows) {
      String league = row.get("League");
      welcomePage.selectFavourite(league);
    }
  }

  @And("user presses the {string} button")
  public void user_presses_the_button(String continueBtn) throws InterruptedException {
    // press continue button
    welcomePage.continuePrimaryBtn.click();
    Thread.sleep(2000);
  }

  @And("user is on allow location popup and clicks on Later option")
  public void user_is_on_allow_location_popup_and_clicks_on_Later_option() {
    // handling with location pop-up
    welcomePage.handleLocationPopup("later");
  }

  @When("user selects teams as follows")
  public void user_selects_teams_as_follows(io.cucumber.datatable.DataTable dataTable) {
    // used data table to read data for selecting multiple values for favourite teams
    List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
    for (Map<String, String> row : rows) {
      String team = row.get("Team");
      welcomePage.selectFavourite(team);
    }
  }

  @And("user presses the {string} another button")
  public void user_presses_the_another_button(String continueBtn) {
    // press continue button
    welcomePage.continuePrimaryBtn.click();
  }

  @And("user presses {string}")
  public void user_presses(String doneBtn) {
    // press done on Never miss a game page
    welcomePage.selectFavourite(doneBtn);
  }

  @And("user is displayed theScore Bet app popup")
  public void user_is_displayed_theScore_Bet_app_popup() {
    // verify "theScore Bet" app pop-up is displayed
    boolean isPopupVisible = welcomePage.isPopupDisplayed();
    Assert.assertTrue("The pop-up is not displayed as expected", isPopupVisible);
  }

  @And("user closes the pop-up")
  public void user_closes_the_pop_up() {
    // close "theScore Bet" app pop-up
    welcomePage.closePopup();
  }

  @Then("user lands on home page")
  public void user_lands_on_home_page() {
    // handle pop-up for Allow Notification which is Android generated and verify Home Page
    try {
      if (welcomePage.allowNotificationBtn.isDisplayed()) {
        welcomePage.allowNotificationBtn.click();
      }
    } catch (Exception e) {
      boolean isDashboardVisible = welcomePage.navigationFavorites.isDisplayed();
      Assert.assertTrue("The main dashboard is not displayed as expected", isDashboardVisible);
    }
  }
}
