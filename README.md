## ----Appium Framework----

# Project Overview
```
Developed from scratch for a technical challenge, this robust and efficient test automation framework combines Data-Driven Testing and Page Object Model methodologies, focusing on key functions of theScore Android app.

The test suite focuses on key functionalities as specified in the technical challenge guide, without aiming for exhaustive coverage of the app’s features.

Two feature files were created, adhering to the requirements of the coding technical interview, demonstrating the ability to set up a framework from scratch and emphasizing the structure and coverage of main test scenarios.
```

#### Dependencies

The project relies on several Maven dependencies, including:

````
Cucumber for Java (for BDD approach)
Appium Java-Client
Selenium Java
AssertJ (for assertions)
Apache Commons Lang (for Java utility classes)
````

#### Installation and Pre-requisites:

````
Java 11.0.22 
Appium 1.22.3 
Maven 3.9.6
Android Studio Iguana | 2023.2.1 Patch 1
````

### **Environment Setup**

1. Install Node.js and NPM
- Download and install Node.js from [Node.js website](https://nodejs.org/)
- Verify the installation in Command Prompt: `node -v` `npm -v`

2. Install Java JDK

- Download the Java JDK from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html).
- Install the JDK and note down the installation path.
- Set the `JAVA_HOME` environment variable

3. Install Maven

- Download and install Maven 3.9.6 from [Apache Maven Project](https://maven.apache.org/download.cgi).
- Extract and set the Maven path in the Environment Variables, similar to `JAVA_HOME`

4. Install and Configure Appium

- Install Appium via NPM: `npm install -g appium@1.22.3`
- Optionally, install Appium Doctor: `npm install -g appium-doctor`
- Run Appium Doctor to verify the installation: `appium-doctor`

5. Install Android Studio and Set Up the Emulator

- Download and install Android Studio from [Android Developer website](https://developer.android.com/studio/).
- Follow the installation instructions and make sure to install the Android Virtual Device component.
- Open Android Studio and install the necessary SDKs and tools through the SDK Manager.

6. Add required environment variables in .zshrc file (eg. JAVA_HOME, MAVEN_HOME and ANDROID_HOME)

7. Cloning the Repository
```` Command: git clone "https://github.com/Hiteshi13/theScore-MobileAutomation-Hiteshi" ````

## **Running the Tests**

## Configuration

Before running the tests, set up the following device emulator:

````Device Name: Pixel 7````

 ## Desired Capabilities for Appium Inspector :-
 ````
 {
  "platformName": "android",
  "appium:platformVersion": "12",
  "appium:deviceName": "Pixel 7",
  "appium:appActivity": "com.fivemobile.thescore",
  "appium:udid": "emulator-5554",
  "appium:automationName": "UIAutomator2"
}
 ````

- Ensure the theScore.apk installed on the device.
- Ensure the Appium server is running.
- Start the Android emulator or connect an Android device.

## **Test Execution**
The project includes two feature files for testing:

 ````Welcome.feature**: Validates the app's first-time launch and selecting favourite league/teams.````
 ````Leagues.feature**: Regular testing for getting leagues Standing and Leaders.````

## **Initial App Launch (Welcome.feature)**

````Important:```` If you decide to run instead the `Leagues.feature` using the `@leagues` tag for the first time, please ensure to manually launch the app on the connected Android device to complete any initial setup or registration process required by the application.

````To run the welcome sequence test:````

To run the welcome sequence tests, you will need to modify the `tags` option in the `RunnerClass`:

1. Navigate to the `RunnerClass` file located at `src/test/java/runners/RunnerClass.java`.
2. Change the `tags` attribute in `@CucumberOptions` to `@welcome`.
3. Save the changes.
4. Open the command prompt or terminal.
5. Navigate to the root directory of the project.
6. Execute the tests using Maven with the command:

`mvn test`

This command will trigger the test runner to execute only the tests marked with the `@welcome` tag.

#### **League Tests (Leagues.feature)**

**To run the league-related tests:**

1. Make sure the app has been launched manually on your device if this is the first run (if you did not launch the Welcome.feature before). When you launch it go via the all set-upping stepDefinition and then when the main dashboard appear just close it and relaunch this test.
2. Navigate to the `RunnerClass` file located at `src/test/java/runners/RunnerClass.java`.
3. Change the `tags` attribute in `@CucumberOptions` to `@leagues`.
4. Save the changes.
5. Open the command prompt or terminal.
6. Navigate to the root directory of the project.
7. Execute the tests using Maven with the command:

`mvn test`

## Note: ````The `dryRun` option is currently set to `false`, which means that the tests will be executed. If you want to ensure that the Cucumber stepDefinition are well-defined without actually running the tests, you can set `dryRun` to `true` temporarily.````

## ------ Project Framework Structure and Design -------

The framework is structured for optimal organization and ease of use:

````
apk folder: Contains the theScore.apk file.
test folder: Includes java and resources subfolders.
java folder: packages for POM pages, runners, stepDefinition and utils.
resources folder: Contains the config.properties file and feature files.
````

## Data-Driven Elements

````The Cucumber Scenario Outline is used to achieve data-driven testing, enabling the execution of tests with various data sets for thorough coverage.````

## Test Cases

````Includes pages, stepDefinitions, utils, resources and feature files to execute tests````

## README.md file for setup and project structure

## pom.xml for dependencies

## Format Java code with google-java-format

````
mvn com.coveo:fmt-maven-plugin:check
mvn com.coveo:fmt-maven-plugin:format
````

## Coverage Assessment

````
The test suite focuses on key functionalities as specified in the mobile test automation task.
Two feature files were created, covering to the requirements of the technical interview.
It demonstrates the ability to set up a framework from scratch and emphasizing the structure and coverage of mentioned test scenarios.
````

## Framework Selection

````
Appium is selected for its capability to automate across different mobile platforms, providing a comprehensive testing solution for mobile applications.
Java language is known for its stability and integration with numerous testing libraries, making it a reliable choice for building a test automation framework.
Cucumber facilitates Behavior-Driven Development (BDD), enhancing the clarity and business alignment of test cases.
````