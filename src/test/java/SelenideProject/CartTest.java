package SelenideProject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CartTest extends TestBase {

    @Test
    public void openEmptyCartTest() throws Exception {
        SelenideProject.CartPage cartPage = new CartPage();
        SelenideProject.CheckoutPage checkoutPage = new CheckoutPage();

        cartPage.openCart();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkoutPage.cartEmptyIsOpened());
        softAssert.assertEquals(checkoutPage.getCartEmptyMessage(), "There are no items in your cart.");
        softAssert.assertAll();
    }

    @Test
    public void openCartWithItemsTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        SelenideProject.CartPage cartPage = new CartPage();
        SelenideProject.CheckoutPage checkoutPage = new CheckoutPage();

        productListPage.openPDP();
        productDetailPage.addToCart();

        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(productDetailPage.getCartItemsQuantity(), "1"));

        cartPage.openCart();

        Assert.assertTrue(checkoutPage.cartWithGoodsIsOpened());
    }

}