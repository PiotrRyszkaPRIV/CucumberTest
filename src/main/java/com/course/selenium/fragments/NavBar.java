package com.course.selenium.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.Helpers.ElementHelper.clickButton;

public class NavBar {

    @FindBy(id = "header_logo")
    private WebElement logoDiv;

    private WebDriver driver;

    public NavBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogo() {
        clickButton(driver,logoDiv);
    }

    public void toggleUserDropdown() {
        driver.findElement(By.id("user_info_acc")).click();
    }

    public void selectAccounts() {
        driver.findElement(By.xpath("//a[text()='Accounts']")).click();
    }
}
