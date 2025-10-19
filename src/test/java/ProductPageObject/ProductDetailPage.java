package ProductPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends TestBase {

    private final By addToCartButton = By.cssSelector("div#box-product button[name='add_cart_product']");
    private final By cartItemsQuantity = By.cssSelector("div#cart span[class='quantity']");

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getCartItemsQuantity() {
        return cartItemsQuantity;
    }

    public By getAddToCartButton() {
        return addToCartButton;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getAddToCartButtonText() {
        return driver.findElement(addToCartButton).getText();
    }

    public String getCartItemsQuantityText() {
        return driver.findElement(cartItemsQuantity).getText();
    }

}