package com.craigjperry.canbusexplorer.feature.presentationformat;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.FluentAdapter;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class PresentationFormatSteps extends FluentAdapter {

    @Page
    CanbusExplorerSinglePageApplication appPage;

    @Before
    public void before() {
        this.initFluent(new HtmlUnitDriver());
        this.initTest();
    }

    @After
    public void after() {
        this.quit();
    }

    @Given("^the app has been started$")
    public void the_app_has_been_started() throws Throwable {
        appPage.go();
    }

    @When("^I visit the application URL on my (\\w+)$")
    public void i_visit_the_application_URL_on_my(String deviceType) throws Throwable {
        appPage.isAt();
    }

    @Then("^I should see the panel (\\w+)$")
    public void i_should_see_the_panel(String panelName) throws Throwable {
        appPage.isVisible(panelName);
    }
}
