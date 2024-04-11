package test.java.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonClass;

public class WelcomePage extends CommonClass {

  @AndroidFindBy(xpath = "//*[@text='WELCOME']")
  public MobileElement welcomeTxt;

  @AndroidFindBy(id = "img_location")
  public MobileElement locationPopup;

  @AndroidFindBy(id = "btn_disallow")
  public MobileElement noLocation;

  @AndroidFindBy(id = "btn_allow")
  public MobileElement allowLocation;

  @AndroidFindBy(xpath = ".//android.widget.Button[@text='Allow']")
  public MobileElement allowNotificationBtn;

  @AndroidFindBy(id = "btn_primary")
  public MobileElement continuePrimaryBtn;

  @AndroidFindBy(id = "navigation_favorites")
  public MobileElement navigationFavorites;

  // method to handle the pop-up for location
  public void handleLocationPopup(String action) {
    try {
      if (locationPopup.isDisplayed()) {
        if ("later".equalsIgnoreCase(action)) {
          noLocation.click();
          System.out.println("Clicked 'Maybe Later' on location popup");
        } else if ("allow".equalsIgnoreCase(action)) {
          allowLocation.click();
          System.out.println("Clicked 'Allow Location' on location popup");
        }
      }
    } catch (Exception e) {
      System.out.println("Location popup was not displayed" + e.getMessage());
    }
  }

  // method to select Favourite team or league
  public MobileElement selectFavourite(String fav) {
    MobileElement element = null;

    try {
      scrollTowardsAndroidElementNew(fav);
      String xpath = String.format("//android.widget.TextView[@text='%s']", fav);
      element = (MobileElement) driver.findElement(By.xpath(xpath));
      element.click();

    } catch (Exception e) {
      System.out.println("Selected favourite '" + fav + "' not found or not clickable");
    }

    return element;
  }

  // method to scroll towards element using UiScrollable
  private void scrollTowardsAndroidElementNew(String elementText) {
    driver.findElement(
        MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\""
                + elementText
                + "\"))"));
  }

  // method to scroll towards element using TouchAction
  private void scrollTowardsAndroidElement(MobileElement element) {
    TouchAction touchAction = new TouchAction(driver);
    int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
    int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
    int endY =
        driver.manage().window().getSize().getHeight()
            / 4; // Scroll up to a quarter of the screen height

    // Scroll action
    touchAction
        .press(PointOption.point(startX, startY))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
        .moveTo(PointOption.point(startX, endY))
        .release()
        .perform();
  }

  // close pop-up appearing on Home Page
  public void closePopup() {
    By closeButtonLocator = By.id("dismiss_modal");
    WebElement closeButton = driver.findElement(closeButtonLocator);
    closeButton.click();
  }

  // verify pop-up is displayed
  public boolean isPopupDisplayed() {
    try {
      By popupLocator = By.id("dismiss_modal");
      WebElement popup = driver.findElement(popupLocator);
      return popup.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public WelcomePage() {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }
}
