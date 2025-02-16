package pages
import com.microsoft.playwright.Page

class NavBar {
    Page page

    String nav_men = "//a[@id=\"ui-id-5\"]"
    String nav_men_tops = "//a[@id=\"ui-id-17\"]"
    String nav_men_tops_jackets = "//a[@id=\"ui-id-19\"]"

    NavBar(Page page) {
        this.page = page
    }

    NavBar clickMenCategory() {
        page.hover(nav_men)
        return this
    }

    NavBar clickTopsSection() {
        page.hover(nav_men_tops)
        return this
    }

    NavBar clickJacketsItems() {
        page.click(nav_men_tops_jackets)
        return this
    }
}
