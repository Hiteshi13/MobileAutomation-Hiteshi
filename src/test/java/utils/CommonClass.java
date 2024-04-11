package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import stepDefinition.PageInitializer;

public class CommonClass extends PageInitializer {

  public static AppiumDriver driver;

  // method to launchapp using set desired capabilities
  public static void launchTheApp() {
    ReadConfig.getProperties(Constants.CONFIG_READER_PATH);
    File appDir = new File(ReadConfig.getProperty("appPath"));
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
    capabilities.setCapability("noReset", "true");
    capabilities.setCapability("deviceName", "emulator-5554");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("automatorName", "UIAutomator2");
    capabilities.setCapability("noSign", "true");
    capabilities.setCapability("appPackage", ReadConfig.getProperty("appPackage"));
    capabilities.setCapability("appActivity", ReadConfig.getProperty("appActivity"));

    try {
      URL url = new URL(ReadConfig.getProperty("AppiumServerURL"));
      driver = new AppiumDriver(url, capabilities);
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      System.out.println("App Launched");

      initializePageObjects();

    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  // method to close app after every execution
  public static void closeMobileApp() {
    if (driver != null) {
      // driver.resetApp(); // fresh installs every test case execution
      driver.quit();
    }
  }

  // method to capture screenshots
  public byte[] takeScreenshot(String name) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
    File file = ts.getScreenshotAs(OutputType.FILE);

    try {
      String filePath =
          Constants.SCREENSHOT_FOLDER_PATH + name + "_" + getTimeStamp("yyyy-MM-dd-HH-mm") + ".png";
      FileUtils.copyFile(file, new File(filePath));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return picBytes;
  }

  // method to get timestamp
  public static String getTimeStamp(String pattern) {
    var date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }
}
