package com.rudra;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageCategories extends MainMaven{

    //This method will get all the text from the HomePage
    @Test
    public static void gettingAllTheTextFromHomePage(){

        // Below statements from line 12-18 is just to show that given unique locator is navigation through the website as intended
        clickButton(By.linkText("Computers"));
        clickButton(By.linkText("Electronics"));
        clickButton(By.linkText("Apparel"));
        clickButton(By.linkText("Digital downloads"));
        clickButton(By.linkText("Books"));
        clickButton(By.linkText("Jewelry"));
        clickButton(By.linkText("Gift Cards"));

        // Prints all the String value of given unique locator in console
        System.out.println(getText(By.className("header-menu")));
    }
}
