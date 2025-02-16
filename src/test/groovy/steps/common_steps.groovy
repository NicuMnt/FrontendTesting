package steps

import com.microsoft.playwright.Page
import hooks.TestContext
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class common_steps {

    private Page page = TestContext.page
    private baseUrl = TestContext.properties.getProperty("base.url")

    @Given("I open the browser")
    void openBrowser() {
        // Browser is already initialized in hooks
    }

    @Then("I validate that I am on homepage")
    void validateHomepage () {
        TestContext.homePage.assertPageTitle()
    }

    @Then("I navigate to jackets shopping page")
    void navigateToJacketsShoppingPage() {
        TestContext.navBar.clickMenCategory().clickTopsSection().clickJacketsItems()

    }


    @Then("I click proceed to checkout")
    void clicktocheckout() {
        TestContext.cartModal.clickProceedToCheckoutButton()
    }

}
