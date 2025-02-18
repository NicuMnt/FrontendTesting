package steps
import hooks.TestContext
import io.cucumber.java.en.Then



class login_steps {


    @Then("I Login")
    void standardLogin()
    {
        TestContext.signInPage
                .clicksigninBtn()
                .fillEmail("nn12345@gmail.com")
        // keeping password in clear text, in a real world scenario it will be read from vault secrets or env vars at least.
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
