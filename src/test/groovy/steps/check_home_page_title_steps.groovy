package steps

import com.microsoft.playwright.Page
import hooks.TestContext
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class check_home_page_title_steps {
    private Page page = TestContext.page
    private baseUrl = TestContext.properties.getProperty("base.url")


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

