package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.Helpers.ElementHelper.*;
import static com.course.selenium.Helpers.SeleniumHelper.waitForPageLoaded;

public class LoginPage {
    @FindBy(id = "field-email")
    WebElement loginInput;
    @FindBy(id = "field-password")
    WebElement passwordInput;
    @FindBy(id = "submit-login")
    WebElement signInButton;
    @FindBy(xpath = "//a[@class='account']")
    WebElement userName;

    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver, By.id("field-email"), "controller=authentication");
        PageFactory.initElements(this.driver,this);
    }

    public void loginAs(String email, String password) {
        clickButton(driver, loginInput);
        fillInput(driver, loginInput,"foo@bar.com");

        clickButton(driver, passwordInput);
        fillInput(driver, passwordInput,"foobar");

        clickButton(driver, signInButton);
    }
    public String getLoggedUsername() {
        return getText(driver, userName);
    }
}
