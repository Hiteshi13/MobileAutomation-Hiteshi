package test.java.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonClass;

public class LeaguesPage extends CommonClass {
  @AndroidFindBy(id = "navigation_leagues")
  public MobileElement navigationLeaguesButton;

  @AndroidFindBy(id = "titleTextView")
  public MobileElement titleText;

  String subTabXPathTemplate = "//*[@text='%s']";

  @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton' and @content-desc='Navigate up']")
  public MobileElement backNavigation;

  // method to select sub-tab for example Standings or Leaders
  public void selectSubTab(String subTabName) {
    String xpath = String.format(subTabXPathTemplate, subTabName);
    WebElement subTabElement = driver.findElement(By.xpath(xpath));
    subTabElement.click();
  }

  // method to get name of current sub-tab
  public String getCurrentSubTabName() {
    List<MobileElement> subTabs = driver.findElements(By.xpath("//android.widget.TextView"));

    for (MobileElement subTab : subTabs) {
      if ("true".equals(subTab.getAttribute("selected"))) {
        return subTab.getText();
      }
    }
    return null;
  }

  public LeaguesPage() {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }
}
