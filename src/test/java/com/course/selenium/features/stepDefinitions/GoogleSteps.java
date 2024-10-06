package com.course.selenium.features.stepDefinitions;

import com.course.selenium.browserFactory.BrowserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.course.selenium.Helpers.SeleniumHelper.waitForPageLoaded;

public class GoogleSteps {

    private final WebDriver driver = BrowserFactory.getDriver();

    @Given("an open browser with google.com")
    public void anOpenBrowserWithGoogleCom() {
        driver.get("http://www.google.com");
        WebElement elementCookiesWindow = driver.findElement(By.xpath("//button/*[contains(text(),'Zaakceptuj')]"));
        elementCookiesWindow.click();
    }

    @When("a {string} selenium is entered in input field")
    public void aKeywordSeleniumIsEnteredInInputField(String keyword) {
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys(keyword);
        element.submit();
    }

    @Then("url contain {string}")
    public void theFirstOneShouldContain(String arg0) {
        waitForPageLoaded(driver,By.cssSelector(".a4bIc #APjFqb"), arg0);
        Assert.assertTrue(driver.findElement(By.cssSelector(".a4bIc #APjFqb")).getText().contains(arg0));
    }

}
