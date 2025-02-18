package pages
import com.microsoft.playwright.Page

class ShippingPage {
    Page page

    // Locators
    String email_address = "(//input[@id=\"customer-email\"])[1]"
    String firstname = "//input[@name=\"firstname\"]"  //(//input[@class="input-text"])[4]
    String lastname = "(//input[@class=\"input-text\"])[5]"
    String company = "(//input[@class=\"input-text\"])[7]"
    String street_address = "(//input[@class=\"input-text\"])[7]"
    String city = "(//input[@class=\"input-text\"])[10]"
    String zip_postal_code = "(//input[@class=\"input-text\"])[12]"
    String phone_number = "(//input[@class=\"input-text\"])[13]"
    String state_province = "(//select[@class=\"select\"])[1]"
    String country = "(//select[@class=\"select\"])[2]"
    String shipping_method_fixed = "(//input[@class=\"radio\"])[1]"
    String next_button = "//button[@class=\"button action continue primary\"]"
    String place_order = "//button[@class=\"action primary checkout\"]"

    ShippingPage(Page page) {
        this.page = page
    }

    ShippingPage clickPlaceOrder() {
        page.click(place_order)
        return this
    }

    ShippingPage enterEmail(String email) {
        page.fill(email_address, email)
        return this
    }


    ShippingPage clickShippingMethodFixed() {
        page.click(shipping_method_fixed)
        return this
    }

    ShippingPage clickNextButton() {
        page.click(next_button)
        return this
    }

    ShippingPage enterFirstName(String firstName) {
        page.fill(firstname, firstName)
        return this
    }

    ShippingPage enterLastName(String lastName) {
        page.fill(lastname, lastName)
        return this
    }

    ShippingPage enterCompany(String companyName) {
        page.fill(company, companyName)
        return this
    }

    ShippingPage enterStreetAddress(String street) {
        page.fill(street_address, street)
        return this
    }

    ShippingPage enterCity(String cityName) {
        page.fill(city, cityName)
        return this
    }

    ShippingPage enterZipCode(String zipCode) {
        page.fill(zip_postal_code, zipCode)
        return this
    }

    ShippingPage enterPhoneNumber(String phone) {
        page.fill(phone_number, phone)
        return this
    }


    ShippingPage selectState() {
        String fourthOptionValue = page.locator(state_province).locator("option").nth(3).getAttribute("value")
        page.selectOption(state_province, fourthOptionValue)
        return this
    }

    ShippingPage selectCountry() {
        String fourthOptionValue = page.locator(country).locator("option").nth(3).getAttribute("value")
        page.selectOption(country, fourthOptionValue)
        return this
    }
}


class ShippingPageLoggedinUser {
    Page page

    ShippingPageLoggedinUser(Page page) {
        this.page = page
    }

    String firstname = "//input[@name=\"firstname\"]"  //(//input[@class="input-text"])[4]
    String lastname = "(//input[@class=\"input-text\"])[4]"
    String company = "(//input[@class=\"input-text\"])[5]"
    String street_address = "(//input[@class=\"input-text\"])[6]"
    String city = "(//input[@class=\"input-text\"])[9]"
    String zip_postal_code = "(//input[@class=\"input-text\"])[11]"
    String phone_number = "(//input[@class=\"input-text\"])[12]"
    String state_province = "(//select[@class=\"select\"])[1]"
    String country = "(//select[@class=\"select\"])[2]"
    String shipping_method_fixed = "(//input[@class=\"radio\"])[1]"
    String next_button = "//button[@class=\"button action continue primary\"]"
    String place_order = "//button[@class=\"action primary checkout\"]"

    ShippingPageLoggedinUser clickPlaceOrder() {
        page.click(place_order)
        return this
    }


    ShippingPageLoggedinUser clickShippingMethodFixed() {
        page.click(shipping_method_fixed)
        return this
    }

    ShippingPageLoggedinUser clickNextButton() {
        page.click(next_button)
        return this
    }

    ShippingPageLoggedinUser enterFirstName(String firstName) {
        page.fill(firstname, firstName)
        return this
    }

    ShippingPageLoggedinUser enterLastName(String lastName) {
        page.fill(lastname, lastName)
        return this
    }

    ShippingPageLoggedinUser enterCompany(String companyName) {
        page.fill(company, companyName)
        return this
    }

    ShippingPageLoggedinUser enterStreetAddress(String street) {
        page.fill(street_address, street)
        return this
    }

    ShippingPageLoggedinUser enterCity(String cityName) {
        page.fill(city, cityName)
        return this
    }

    ShippingPageLoggedinUser enterZipCode(String zipCode) {
        page.fill(zip_postal_code, zipCode)
        return this
    }

    ShippingPageLoggedinUser enterPhoneNumber(String phone) {
        page.fill(phone_number, phone)
        return this
    }


    ShippingPageLoggedinUser selectState() {
        String fourthOptionValue = page.locator(state_province).locator("option").nth(3).getAttribute("value")
        page.selectOption(state_province, fourthOptionValue)
        return this
    }

    ShippingPageLoggedinUser selectCountry() {
        String fourthOptionValue = page.locator(country).locator("option").nth(3).getAttribute("value")
        page.selectOption(country, fourthOptionValue)
        return this
    }
}


