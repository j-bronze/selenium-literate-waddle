package CartPageObject;

import ProductPageObject.ProductDetailPage;
import ProductPageObject.ProductListPage;
import TestBase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CartTest extends TestBase {

    @Test
    public void openEmptyCartTest() {
        CartPageObject.CartPage cartPage = new CartPage(driver);
        CartPageObject.CheckoutPage checkoutPage = new CheckoutPage(driver);

        cartPage.openCart();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkoutPage.cartEmptyIsOpened());
        softAssert.assertEquals(checkoutPage.getCartEmptyMessage(), "There are no items in your cart.");
        softAssert.assertAll();
    }

    @Test
    public void openCartWithItemsTest() {
        ProductListPage productListPage = new ProductListPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        CartPageObject.CartPage cartPage = new CartPage(driver);
        CartPageObject.CheckoutPage checkoutPage = new CheckoutPage(driver);

        productListPage.openPDP();
        productDetailPage.addToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(productDetailPage.getCartItemsQuantity(), "1"));

        cartPage.openCart();

        Assert.assertTrue(checkoutPage.cartWithGoodsIsOpened());
    }

}