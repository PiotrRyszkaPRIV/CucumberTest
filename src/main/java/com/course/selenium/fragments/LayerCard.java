package com.course.selenium.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LayerCard {

    @FindBy(css = "#layer_cart .button-medium")
    private WebElement proceedToCheckOut;


    private final By layerSummaryWindow = By.id("cart_summary");

    private WebDriver driver;
    private WebDriverWait wait;

    public LayerCard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckOut(){
        proceedToCheckOut.click();
        wait.ignoring(StaleElementReferenceException.class)
                .until(presenceOfElementLocated(layerSummaryWindow));
    }

}
