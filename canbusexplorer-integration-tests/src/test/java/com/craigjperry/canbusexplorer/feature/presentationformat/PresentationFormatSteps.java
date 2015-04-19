package com.craigjperry.canbusexplorer.feature.presentationformat;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PresentationFormatSteps {

    public WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("^the app has been started$")
    public void the_app_has_been_started() throws Throwable {
        driver.get("http://localhost:8080");
        assertThat(driver.getTitle(), equalTo("Canbus Explorer"));
    }

    @When("^I visit the application URL on my (\\w+)$")
    public void i_visit_the_application_URL_on_my(String deviceType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see the panel (\\w+)$")
    public void i_should_see_the_panel(String panelName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
