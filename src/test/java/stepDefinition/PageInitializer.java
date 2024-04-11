package test.java.stepDefinition;

import pages.*;

public class PageInitializer {
  // objects of Pages created
  public static WelcomePage welcomePage;
  public static LeaguesPage leaguesPage;

  // initialization of Page Objects
  public static void initializePageObjects() {
    welcomePage = new WelcomePage();
    leaguesPage = new LeaguesPage();
  }
}
