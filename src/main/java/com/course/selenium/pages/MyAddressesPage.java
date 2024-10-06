package com.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.Helpers.ElementHelper.clickButton;

public class MyAddressesPage {

    @FindBy(css = "a[title='Add an address']")
    private WebElement addAnewAddressButton;

    private final WebDriver driver;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddAnewAddressButton() {
        clickButton(driver, addAnewAddressButton);
    }
}
