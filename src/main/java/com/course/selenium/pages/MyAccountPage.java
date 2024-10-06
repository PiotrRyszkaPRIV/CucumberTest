package com.course.selenium.pages;

import com.course.selenium.fragments.NavBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.course.selenium.Helpers.ElementHelper.clickButton;
import static com.course.selenium.Helpers.ElementHelper.getText;
import static com.course.selenium.Helpers.SeleniumHelper.waitForPageLoaded;

public class MyAccountPage {

    public NavBar navbar;
    private final WebDriver driver;


    @FindBy(css = ".myaccount-link-list a[title=Addresses]")
    private WebElement myAddressesButton;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver,By.cssSelector(".myaccount-link-list a[title=Addresses]"), "my-account" );
        this.navbar = new NavBar(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessMessageShown() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".alert-success"));
        return !elements.isEmpty();
    }
    
    public String getSuccessMessage() {
        return getText(driver,By.cssSelector(".alert-success"));
    }

    public void clickMyAddresses() {
        clickButton(driver,myAddressesButton);
    }
}
