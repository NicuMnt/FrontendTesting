package steps

import com.microsoft.playwright.Page
import hooks.PlaywrightHooks
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class check_home_page_title_steps {
    private Page page = PlaywrightHooks.page
    private baseUrl = PlaywrightHooks.properties.getProperty("base.url")

    @Given("I open the browser")
    void openBrowser() {
        // Browser is already initialized in hooks
    }


    @When("I navigate to the homepage")
    void navigateToHomePage() {
        println "testsdadsa, $baseUrl"
        page.navigate(baseUrl)
    }

    @Then("I should see the title contains {string}")
    void verifyTitle(String expectedTitle) {
        assert page.title().contains(expectedTitle)
    }
}

