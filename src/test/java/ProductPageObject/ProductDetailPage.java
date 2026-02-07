package ProductPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static TestBase.Locators.getLocator;

public class ProductDetailPage extends TestBase {

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getCartItemsQuantity() throws Exception {
        return getLocator("ProductDetailPage.CartItemsQuantity");
    }

    public By getAddToCartButton() throws Exception {
        return getLocator("ProductDetailPage.AddToCartButton");
    }

    public void addToCart() throws Exception {
        driver.findElement(getLocator("ProductDetailPage.AddToCartButton")).click();
    }

    public String getAddToCartButtonText() throws Exception {
        return driver.findElement(getLocator("ProductDetailPage.AddToCartButton")).getText();
    }

    public String getCartItemsQuantityText() throws Exception {
        return driver.findElement(getLocator("ProductDetailPage.CartItemsQuantity")).getText();
    }

}