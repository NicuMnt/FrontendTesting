package pages
import com.microsoft.playwright.Page




class SignInPage {
    Page page

       String signin_btn = "(//li[@class=\"authorization-link\"])[1]"
       String emailxpath = "//input[@id=\"email\"]"
       String passwordxpath = "(//input[@id=\"pass\"])[1]"
       String signin_btnlogin = "(//button[@id=\"send2\"])[1]"

    SignInPage(Page page) {
        this.page = page
    }

    SignInPage clicksigninBtn() {
        page.click(signin_btn)
        return this
    }

    SignInPage fillEmail(String email) {
        page.fill(emailxpath, email)
        return this
    }

    SignInPage clicksigninBtnlogin() {
        page.click(signin_btnlogin)
        return this
    }

    SignInPage fillpassword(String password) {
        page.fill(passwordxpath, password)
        return this
    }

}
