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
        // Get jacket details from the product page
        String card_price = TestContext.jacketsShoppingPage.getCardPrice()
        String card_size_text = TestContext.jacketsShoppingPage.getCard_jacket_size()
        String card_image_url = TestContext.jacketsShoppingPage.getCardImageURL()

        // Open cart modal
        TestContext.cartModal.clickCartButton()

        // Get cart details
        String cart_price = TestContext.cartModal.getPriceExcludingTax()
        String shopping_cart_item_size = TestContext.cartModal.getShoppingCartItemSize()
        String shopping_cart_item_color = TestContext.cartModal.getShoppingCartItemColor()

        String cart_image_url = TestContext.cartModal.getCartImageURL()

        // Assert that the quantity is 1
        TestContext.cartModal.assertQuantityIsOne()

        // Assert that the color is blue
        TestContext.cartModal.assertColorIsBlue()

        // Assert that the product size in the cart matches the selected size
        assert card_size_text.trim() == shopping_cart_item_size.trim() : "Size mismatch! Expected: $card_size_text, but found: $shopping_cart_item_size"

        assert shopping_cart_item_color.trim() == 'Blue' : "Color mismatch! Expected: $shopping_cart_item_color, not blue"

        // Assert that the product price in the cart matches the selected price
        assert card_price.trim() == cart_price.trim() : "Price mismatch! Expected: $card_price, but found: $cart_price"

        // Assert that the image URLs match
//        TestContext.cartModal.assertImageUrlsAreEqual(card_image_url, cart_image_url)
    }
}

