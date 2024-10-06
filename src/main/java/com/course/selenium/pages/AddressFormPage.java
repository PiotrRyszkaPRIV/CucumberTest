package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.Helpers.ElementHelper.clickButton;
import static com.course.selenium.Helpers.ElementHelper.fillInput;
import static com.course.selenium.Helpers.SeleniumHelper.waitForPageLoaded;


public class AddressFormPage {

    @FindBy(id = "address1")
    private WebElement addressLine1Input;

    @FindBy(id = "postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasInput;

    @FindBy(id = "submitAddress")
    private WebElement saveButton;

    private WebDriver driver;

    public AddressFormPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver, By.cssSelector("#address1"), "address");
        PageFactory.initElements(driver, this);
    }

    public void typeAddressLine(String line) {
        fillInput(driver,addressLine1Input,line);
    }

    public void typePostalCode(String postalCode) {
        fillInput(driver,postalCodeInput,postalCode);
    }

    public void typeCity(String city) {
        fillInput(driver,cityInput,city);
    }

    public void typeHomePhone(String phone) {
        fillInput(driver,homePhoneInput,phone);
    }

    public void typeAlias(String alias) {
        fillInput(driver,aliasInput,alias);
    }

    public void clickSaveButton() {
        clickButton(driver,saveButton);
    }
}
