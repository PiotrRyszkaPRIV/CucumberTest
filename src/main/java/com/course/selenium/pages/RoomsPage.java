package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.course.selenium.Helpers.SeleniumHelper.waitForPageLoaded;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RoomsPage {

    @FindBy(css = ".room_cont")
    private List<WebElement> rooms;

    private final By locatorLayerCars = By.cssSelector("div[id='layer_cart']");
    private final By locatorProceedButton = By.cssSelector(".ajax_add_to_cart_button");
    private final By locatorRoomHeader = By.cssSelector(".rm_heading");


    private final WebDriverWait wait;

    public RoomsPage(WebDriver driver) {
        waitForPageLoaded(driver,By.cssSelector(".rm_heading"));
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getNumRooms() {
        return rooms.size();
    }

    public void clickBookNowButton(String headerName){
       for(WebElement room : rooms){
           WebElement header = room.findElement(locatorRoomHeader);
           if(header.getText().contains(headerName)){
               WebElement bookNowButton = room.findElement(locatorProceedButton);
               bookNowButton.click();
           }
       }
        this.wait.ignoring(StaleElementReferenceException.class)
                .until(visibilityOfElementLocated(locatorLayerCars)
                );
    }
}
