package steps


import hooks.TestContext
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class common_steps {



    @Given("I open the browser")
    void openBrowser() {
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
