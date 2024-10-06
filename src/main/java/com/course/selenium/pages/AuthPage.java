package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.Helpers.ElementHelper.*;
import static com.course.selenium.Helpers.SeleniumHelper.waitForPageLoaded;

public class AuthPage {
    @FindBy(id = "create_account_error")
    private WebElement createAccountAlert;
    @FindBy(id = "email_create")
    private WebElement createAccountEmailInput;
    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;
    @FindBy(id = "email")
    private WebElement loginEmailInput;
    @FindBy(id = "passwd")
    private WebElement loginPasswordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;
    private final WebDriver driver;
    public AuthPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver,By.cssSelector("#email_create"), "my-account" );
        PageFactory.initElements(this.driver, this);
    }
    public void typeEmailIntoCreateAccount(String email) {
        fillInput(driver,createAccountEmailInput, email);
    }

    public void clickCreateAccountButton() {
        clickButton(driver, createAccountButton);
    }

    public boolean isErrorMessageShown() {
        return createAccountAlert.isDisplayed();
    }

    public String getErrorMessage() {
        return getText(driver, createAccountAlert);
    }

    public void typeEmailIntoLogin(String email) {
        fillInput(driver,loginEmailInput,email );
    }

    public void typePassword(String password) {
        fillInput(driver,loginPasswordInput,password );
    }

    public void clickSignInButton() {
        clickButton(driver, signInButton);
    }

}
