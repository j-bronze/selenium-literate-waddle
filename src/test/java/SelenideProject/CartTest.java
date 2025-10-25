package SelenideProject;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import java.time.Duration;

@Epic("Adding a product to the cart")
@Feature("Open cart")
public class CartTest extends TestBase {

    @Description("This test checks that it is possible to open an empty cart")
    @Test(description = "Open empty cart")
    public void openEmptyCartTest() throws Exception {
        SelenideProject.CartPage cartPage = new CartPage();
        SelenideProject.CheckoutPage checkoutPage = new CheckoutPage();

        cartPage.openCart();

        checkoutPage.getCartEmptyMessage().shouldBe(visible).shouldHave(text("There are no items in your cart."));
    }

    @Description("This test checks the items in the cart")
    @Test(description = "Open cart with added items")
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

        checkoutPage.cartWithGoodsIsOpened().shouldBe(visible);
    }

}