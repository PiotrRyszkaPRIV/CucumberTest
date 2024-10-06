package com.course.selenium.pages;

import com.course.selenium.fragments.NavBar;
import com.course.selenium.fragments.SelectHotel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.Helpers.ElementHelper.clickButton;
import static com.course.selenium.Helpers.ElementHelper.fillInput;

public class HomePage {

    public NavBar navbar;
    public SelectHotel selectHotel;

    @FindBy(css = ".hide_xs")
    private WebElement signInLink;

    @FindBy(id = "hotel_location")
    private WebElement hotelLocationInput;

    @FindBy(id = "hotel_cat_id")
    private WebElement hotelCategoryIdInput;

    @FindBy(id = "check_in_time")
    private WebElement checkInTimeInput;

    @FindBy(id = "check_out_time")
    private WebElement checkOutTimeInput;

    @FindBy(id = "search_room_submit")
    private WebElement searchHotelButton;
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navbar = new NavBar(driver);
        this.selectHotel = new SelectHotel(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickSignInLink() {
        clickButton(driver,signInLink);
    }

    public void typeLocation(String location) {
        fillInput(driver,hotelLocationInput,location);
    }

    public void typeCheckInDate(String ddMMyyyy) {
        fillInput(driver,checkInTimeInput,ddMMyyyy);
    }

    public void typeCheckOutDate(String ddMMyyyy) {
        fillInput(driver,checkOutTimeInput,ddMMyyyy);

    }

    public void clickSearchButton() {
        searchHotelButton.click();
    }
}
