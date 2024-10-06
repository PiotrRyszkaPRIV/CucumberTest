package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.Helpers.ElementHelper.clickButton;
import static com.course.selenium.Helpers.ElementHelper.fillInput;
import static com.course.selenium.Helpers.SeleniumHelper.waitForPageLoaded;

public class CreateAccountPage {

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    private final WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver,By.cssSelector("#customer_lastname"), "#account-creation" );
        PageFactory.initElements(this.driver, this);
    }

    public void typeFirstName(String name) {
        fillInput(driver,firstNameInput, name);
    }

    public void typeLastName(String surname) {
        fillInput(driver,lastNameInput, surname);
    }

    public void typePassword(String password) {
        fillInput(driver,passwordInput, password);
    }

    public void clickRegisterButton() {
        clickButton(driver, registerButton);
    }
}
