package pages
import com.microsoft.playwright.Page

class HomePage {
    Page page

    String cart_btn = '//span[@data-ui-id="page-title-wrapper"]'


    HomePage(Page page) {
        this.page = page
    }

    void assertPageTitle() {
        String title = page.title()

        assert title == "Home Page" : "Expected page title to be 'Home Page', but found '${title}'"
    }


}
