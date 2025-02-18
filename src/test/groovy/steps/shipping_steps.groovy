package steps


import com.microsoft.playwright.Page
import hooks.TestContext
import io.cucumber.java.en.Then

import com.microsoft.playwright.options.WaitForSelectorState

class shipping_steps {

    @Then("I fill Shipping page")
    void shipping_page_fill() {
        // Wait for the first field (email) to be visible before proceeding
        TestContext.shippingPage.page.waitForSelector(TestContext.shippingPage.email_address,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE))

        TestContext.shippingPage
                .enterEmail("nn12345@example.com")
                .enterFirstName("John")
                .enterLastName("Doe")
                .enterCompany("Test Company")
                .enterStreetAddress("123 Test Street")
                .enterCity("Test City")
                .selectState()
                .enterZipCode("12345")
                .selectCountry()
                .enterPhoneNumber("1234567890")
                .clickShippingMethodFixed()
                .clickNextButton()
    }

    @Then("I fill Shipping page for loggedin user")
    void shipping_page_fill_loggedinUser() {


        TestContext.shippingPageLoggedinUser
                .enterFirstName("John")
                .enterLastName("Doe")
                .enterCompany("Test Company")
                .enterStreetAddress("123 Test Street")
                .enterCity("Test City")
                .selectState()
                .enterZipCode("12345")
                .selectCountry()
                .enterPhoneNumber("1234567890")
                .clickShippingMethodFixed()
                .clickNextButton()
    }

    @Then("I place the order")
    void PlaceOrder() {
        TestContext.shippingPage.clickPlaceOrder()

    }

}

