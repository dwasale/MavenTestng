package com.rudra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class MainMaven {

    protected static WebDriver driver;  // Declaring WebDriver interface as 'driver' for global use

    //This is annotation of testng and this method will be called before calling the main method
    @BeforeMethod
    public static void openBrowser() {
        // System.setProperty() method forms the basis for test automation on any browser
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver");  // Test case automation on chrome
        driver = new ChromeDriver();        // Instantiating as ChromeDriver
        driver.get("https://demo.nopcommerce.com");     // Navigate the given URL and wait till page load
        driver.manage().window();   // It returns instance of option interface and returns instance of window interface
    }

    //This is annotation of testng and this method will be called after calling the main method
    @AfterMethod
    public static void closeBrowser() {
        driver.quit();  // Closes all browser window and ends the WebDriver Session
    }

    //This method is created to get the time stamp
    @Test
    public static String dateTimeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()); // Storing current date and time as given pattern
    }

    //This method will perform click action in given element
    @Test
    public static void clickButton(By by) {
        driver.findElement(by).click();   // Uniquely identify the element within the web page and perform given action
    }

    //This method will give user data to the specific field
    @Test
    public static void sendUserData(By by, String text) {
        driver.findElement(by).sendKeys(text); //Uniquely identify the element within the web page and perform given action
    }

    //This method will get the text value from the element
    @Test
    public static String getText(By by) {
        return driver.findElement(by).getText(); //Uniquely identify the element within the web page and perform given action
    }

    //This is the main method for registering new user
    @Test
    public static void toVerifyNewUserRegistrationSuccessfully() {
        clickButton(By.className("ico-register")); // Uniquely identify the element within the web page and perform given action
        clickButton(By.id("gender-male")); // It identifies the unique element by id and performs click action
        sendUserData(By.id("FirstName"), "Test");  // It identifies the unique element by id and fill in FirstName field with "Test"
        sendUserData(By.id("LastName"), "TestAuto"); // It identifies the unique element by id and fill in LastName field with "TestAuto"
        sendUserData(By.xpath("//select[@name='DateOfBirthDay']"), "12"); // Identifies the unique element by xPath and selects Date of birth Day by "12"
        sendUserData(By.xpath("//select[@name='DateOfBirthMonth']"), "August");  // Identifies the unique element by xPath and selects Date of birth Month by "August"
        sendUserData(By.xpath("//select[@name='DateOfBirthYear']"), "1990"); // Identifies the unique element by xPath and selects Date of birth Year by "1990"
        sendUserData(By.id("Email"), "testmaven" + dateTimeStamp() + "@maven.com");    // Identifies unique element by id and fill it with given user inputs - timeStamp is used in between so everytime we test it will be unique and accepts the data
        sendUserData(By.name("Company"), "ABC Company"); // Identifies unique element by name and fill in Company field with user data "ABC Company"
        sendUserData(By.id("Password"), "abc1234");  // Identifies the unique element by id and fill the Password field with "abc1234"
        sendUserData(By.id("ConfirmPassword"), "abc1234"); // Identifies the unique element by id and fill the ConfirmPassword field with "abc1234" with should be same as above
        clickButton(By.id("register-button")); // Identifies unique element by id and click the Register button

        String message = getText(By.className("result"));  // It stores the value of result in 'message' String variables
        System.out.println(message);    // It prints out stored message variables


    }

    @Test
    public static void toPutCommentsOnMiddleOneOfNewsSection(){
        clickButton(By.xpath("//div[@class='news-item'][2]/div[3]")); //It identifies unique element by xPath and clicks the button
        sendUserData(By.name("AddNewComment.CommentTitle"),"Very Very Good"); // Identifies unique element by name and insert "Very Good" in that field
        sendUserData(By.name("AddNewComment.CommentText"), "One of the demo web " +
                "page to work on for testing. " +
                "The contain are very simple and easy to navigate.");//Identifies unique element by name and insert user input data passed in sendKey() method in that field
        clickButton(By.name("add-comment")); // It will click the button which has unique locator passed in findElement by name
        System.out.println(getText(By.className("result"))); // Prints the message after successful comment on the console
    }

    @Test
    public static void toGetAllTheTextFromDesktopsPageUnderComputer(){
        clickButton(By.linkText("Computers")); // Navigates through given unique locator and performs click action
        clickButton(By.linkText("Desktops")); // Navigates through given unique locator and performs click action
        System.out.println(getText(By.className("center-2"))); // Prints all the texts on console from desktop page
    }

}
