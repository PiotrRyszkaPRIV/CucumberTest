package com.course.selenium.features.stepDefinitions;

import com.course.selenium.browserFactory.BrowserFactory;
import com.course.selenium.pages.AuthPage;
import com.course.selenium.pages.CreateAccountPage;
import com.course.selenium.pages.HomePage;
import com.course.selenium.pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.course.selenium.Helpers.TestHelpers.getRandomEmail;


public class AccountRegistrationSteps {

    private final WebDriver driver = BrowserFactory.getDriver();
    private AuthPage authPage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;


    @Given("the user is on the HomePage")
    public void openHomePage() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInLink();
    }

    @Given("the user is on the authentication page")
    public void theUserIsOnTheAuthenticationPage() {
        authPage = new AuthPage(driver);
    }

    @When("the user types a random email into the create account email input")
    public void theUserTypesARandomEmailIntoTheCreateAccountEmailInput() {
        authPage.typeEmailIntoCreateAccount(getRandomEmail());
    }

    @And("the user clicks on the create an account button")
    public void theUserClicksOnTheCreateAnAccountButton() {
        authPage.clickCreateAccountButton();
    }

    @And("the user fills the required fields on the create account form")
    public void theUserFillsTheRequiredFieldsOnTheCreateAccountForm() {
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.typeFirstName("John");
        createAccountPage.typeLastName("Gigs");
        createAccountPage.typePassword("s3cret");
    }

    @And("the user clicks the register button")
    public void theUserClicksTheRegisterButton() {
        createAccountPage.clickRegisterButton();
    }

    @Then("the user should be logged in their account page")
    public void theUserShouldBeLoggedInTheirAccountPage() {
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.isSuccessMessageShown());
    }

    @And("the account page should display welcome message {string}")
    public void theAccountPageShouldDisplayWelcomeMessage(String expectedMessage) {
        String actualMessage = myAccountPage.getSuccessMessage();
        Assert.assertEquals("Page message should be: " + expectedMessage + " but is: " + actualMessage, "Your account has been created.", actualMessage);
    }

    @When("the user types an existing email {string} into the create account email input")
    public void theUserTypesAnExistingEmailIntoTheCreateAccountEmailInput(String email) {
        authPage.typeEmailIntoCreateAccount(email);
    }

    @Then("the page should display error {string}")
    public void thePageShouldDisplayError(String expectedErrorMessage) {
        String actualMessage = authPage.getErrorMessage();
        Assert.assertEquals("Page message should be: " + expectedErrorMessage + " but is: " + actualMessage, expectedErrorMessage, actualMessage);
    }

    @And("the user fills the create account form with {string}, {string}, {string}")
    public void theUserFillsTheCreateAccountFormWith(String firstName, String lastname, String password) {
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.typeFirstName(firstName);
        createAccountPage.typeLastName(lastname);
        createAccountPage.typePassword(password);
    }

}
