package steps


import hooks.TestContext
import io.cucumber.java.en.Then
import io.cucumber.java.en.When


class jacket_category_steps {



    @When("I select the first jacket in the list")
    void SelectFirstJacket() {
        TestContext.jacketsShoppingPage
                .clickJacketSize()
                .clickSecondBlueColor()
                .hoverJacketCard()
                .clickAddToCart()
    }

    @Then("I validate shopping cart details")
    void ValidateCartDetails() {

        String card_price = TestContext.jacketsShoppingPage.getCardPrice()
        String card_size_text = TestContext.jacketsShoppingPage.getCard_jacket_size()
        String card_image_url = TestContext.jacketsShoppingPage.getCardImageURL()


        TestContext.cartModal.clickCartButton()


        String cart_price = TestContext.cartModal.getPriceExcludingTax()
        String shopping_cart_item_size = TestContext.cartModal.getShoppingCartItemSize()
        String shopping_cart_item_color = TestContext.cartModal.getShoppingCartItemColor()

        String cart_image_url = TestContext.cartModal.getCartImageURL()


        TestContext.cartModal.assertQuantityIsOne()


        TestContext.cartModal.assertColorIsBlue()


        assert card_size_text.trim() == shopping_cart_item_size.trim() : "Size mismatch! Expected: $card_size_text, but found: $shopping_cart_item_size"

        assert shopping_cart_item_color.trim() == 'Blue' : "Color mismatch! Expected: $shopping_cart_item_color, not blue"


        assert card_price.trim() == cart_price.trim() : "Price mismatch! Expected: $card_price, but found: $cart_price"


//        TestContext.cartModal.assertImageUrlsAreEqual(card_image_url, cart_image_url)
    }
}

