package com.course.selenium.features.stepDefinitions;

import com.course.selenium.browserFactory.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.course.selenium.Helpers.TestHelpers.getRandomAlias;
import static com.course.selenium.Helpers.TestHelpers.getRandomEmail;


public class AddAddressesSteps {

    private final WebDriver driver = BrowserFactory.getDriver();
    private AuthPage authPage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;
    private AddressFormPage addressFormPage;

    private String addressAlias;

    @And("the user clicks on My Addresses")
    public void theUserClicksOnMyAddresses() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickMyAddresses();
    }

    @And("the user clicks on Add a new address")
    public void theUserClicksOnAddANewAddress() {
        myAddressesPage = new MyAddressesPage(driver);
        myAddressesPage.clickAddAnewAddressButton();
    }

    @And("the user fills the address form")
    public void theUserFillsTheAddressForm() {
        addressAlias = getRandomAlias();

        addressFormPage = new AddressFormPage(driver);
        addressFormPage.typeAddressLine("Prosta 51");
        addressFormPage.typePostalCode("00-838");
        addressFormPage.typeCity("Warszawa");
        addressFormPage.typeHomePhone("555-555-123");
        addressFormPage.typeAlias(addressAlias);
    }
}
