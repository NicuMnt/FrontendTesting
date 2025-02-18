package pages
import com.microsoft.playwright.Page
import java.security.MessageDigest
import java.nio.file.Files
import java.nio.file.Paths
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.security.MessageDigest
import java.io.InputStream
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.io.FileOutputStream
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.HttpResponse

class CartModal {
    Page page


    String cart_btn = "(//a[@class=\"action showcart\"])[1]"
    String counter_quantity_btn = "(//span[@class=\"counter qty\"])[1]"
    String proceed_to_checkout_btn = "//button[@id=\"top-cart-btn-checkout\"]"
    String see_details_toggle = "//span[@class=\"toggle\"]"
    String edit_item = "//div[@class=\"product actions\"]/div[@class=\"primary\"]"
    String delete_item = "//div[@class=\"product actions\"]/div[@class=\"secondary\"]"
    String confirm_delete_btn = "//button[@class=\"action-primary action-accept\"]"


    String counter_number = "(//span[@class=\"counter-number\"])[1]"
    String counter_label = "(//span[@class=\"counter-label\"])[1]"
    String product_item_name = "//strong[@class=\"product-item-name\"]"
    String product_option_list = "//dl[@class=\"product options list\"]"
    String price_excluding_tax = "//span[@class=\"price-excluding-tax\"]"
    String details_qty = "//input[@class=\"item-qty cart-item-qty\"]"
    String get_image_cart = "(//img[@class='product-image-photo'])[1]"

    String cart_item_size = "(//span[@data-bind=\"text: option.value\"])[1]"
    String cart_item_color = "(//span[@data-bind=\"text: option.value\"])[2]"

    CartModal(Page page) {
        this.page = page
    }

    CartModal clickCartButton() {
        page.waitForSelector("//span[@class='counter-number'][text()='1']", new Page.WaitForSelectorOptions().setTimeout(15000))
        page.click(cart_btn)
        return this
    }

    CartModal clickConfirmDelete() {
        page.waitForSelector("//span[@class='counter-number'][text()='1']", new Page.WaitForSelectorOptions().setTimeout(15000))
        page.click(confirm_delete_btn)
        return this
    }

    void clickCounterQuantityButton() {
        page.click(counter_quantity_btn)
    }

    void clickProceedToCheckoutButton() {
        page.click(proceed_to_checkout_btn)
    }

    void clickSeeDetailsToggle() {
        page.click(see_details_toggle)
    }

    void clickEditItem() {
        page.click(edit_item)
    }

    CartModal clickDeleteItem() {
        page.click(delete_item)
        return this
    }


    String getCounterNumber() {
        return page.textContent(counter_number)
    }

    String getShoppingCartItemSize() {
        return page.textContent(cart_item_size)
    }

    String getShoppingCartItemColor() {
        return page.textContent(cart_item_color)
    }

    String getCounterLabel() {
        return page.textContent(counter_label)
    }

    String getProductItemName() {
        return page.textContent(product_item_name)
    }

    String getProductOptionList() {
        return page.textContent(product_option_list)
    }

    String getPriceExcludingTax() {
        return page.textContent(price_excluding_tax)
    }

    String getDetailsQty() {
        return page.getAttribute(details_qty, "data-item-qty")

    }

    String getCartImageURL() {
        return page.getAttribute(get_image_cart, "src")
    }


    void assertQuantityIsOne() {
        assert getDetailsQty() == "1": "Quantity should be 1"
    }

    void assertColorIsBlue() {
        assert getProductOptionList().contains("Blue"): "Color should be Blue, optionlist is " + getProductOptionList()
    }

    void assertImageUrlsAreEqual(String imageUrl1, String imageUrl2) {

        String hash1 = downloadAndGetImageHash(imageUrl1)
        String hash2 = downloadAndGetImageHash(imageUrl2)

        assert hash1 == hash2: "Image hashes do not match"
    }

    String downloadAndGetImageHash(String imageUrl) {
        try {

            CloseableHttpClient httpClient = HttpClients.createDefault()
            HttpGet httpGet = new HttpGet(imageUrl)
            HttpResponse response = httpClient.execute(httpGet)


            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed to download image. HTTP error code: " + response.getStatusLine().getStatusCode())
            }

            InputStream inputStream = response.getEntity().getContent()


            File tempFile = File.createTempFile("image", ".tmp")
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile)


            byte[] buffer = new byte[1024]
            int bytesRead
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead)
            }


            fileOutputStream.close()
            inputStream.close()
            httpClient.close()


            byte[] fileBytes = Files.readAllBytes(tempFile.toPath())
            MessageDigest digest = MessageDigest.getInstance("SHA-256")
            byte[] hash = digest.digest(fileBytes)

            // prepare bytes to string
            StringBuilder hexString = new StringBuilder()
            for (byte b : hash) {
                hexString.append(String.format("%02x", b))
            }


            tempFile.delete()

            return hexString.toString()

        } catch (Exception e) {
            throw new RuntimeException("Error downloading or hashing the image", e)
        }
    }

}
