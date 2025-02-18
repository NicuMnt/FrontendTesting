package pages
import com.microsoft.playwright.Page

class JacketsShoppingPage {
    Page page

    String card_jacket_size = "(//div[@id=\"option-label-size-143-item-166\"])[1]"
    String add_to_cart_button_first = "(//button[@class=\"action tocart primary\"])[1]"
    String card_price = "(//span[@class='price'])[1]"
    String card_image = "(//img[@class='product-image-photo'])[2]"
    String card_name = "(//a[@class=\"product-item-link\"])[1]"
    String specified_color_blue = "(//div[contains(@class, 'swatch-option')][@option-label='Blue'])[1]"
    String first_jacket_card = '(//ol[@class="products list items product-items"]/li)[1]'

    JacketsShoppingPage(Page page) {
        this.page = page
    }

    JacketsShoppingPage clickJacketSize() {
        page.click(card_jacket_size)
        return this
    }

    String getCard_jacket_size() {
        return page.textContent(card_jacket_size)
    }

    JacketsShoppingPage hoverJacketCard() {
        page.hover(first_jacket_card)
        return this
    }

    JacketsShoppingPage clickSecondBlueColor() {
        page.click(specified_color_blue)
        return this
    }

    JacketsShoppingPage clickAddToCart() {
        page.click(add_to_cart_button_first)
        return this
    }

    String getCardPrice() {
        return page.textContent(card_price)
    }

    String getCardImageURL() {
        return page.getAttribute(card_image, "src")
    }

    String getCardName() {
        return page.textContent(card_name)
    }

}
