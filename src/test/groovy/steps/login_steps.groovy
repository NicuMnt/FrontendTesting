package steps
import com.microsoft.playwright.Page
import hooks.TestContext
import io.cucumber.java.en.Then
import com.microsoft.playwright.options.WaitForSelectorState
import io.cucumber.java.en.When


class login_steps {


    @Then("I Login")
    void standardLogin()
    {
        TestContext.signInPage
                .clicksigninBtn()
                .fillEmail("nn12345@gmail.com")
                .fillpassword("Uahufrif7!")
                .clicksigninBtnlogin()


    }

    @Then("I clear all cart items")
    void clearCartItems() {
        try {
            TestContext.cartModal
                    .clickCartButton()
                    .clickDeleteItem()
                    .clickConfirmDelete()
        } catch (Exception e) {
            println "Nothing to clear from shopping cart"
        }
    }


}
