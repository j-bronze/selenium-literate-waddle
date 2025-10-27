package SelenideProject;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Epic("PLP and PDP")
@Feature("Add a product to the cart on the home page")
public class ProductTest extends TestBase {

    @Description("This test checks that the items on campaign have SALE ribbons")
    @Test(description = "Sale ribbon for item in campaign block")
    public void saleRibbonForCampaignItemTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();

        Configuration.assertionMode = AssertionMode.SOFT;
        productListPage.saleRibbonForCampaignItemIsDisplayed();
        Configuration.assertionMode = AssertionMode.SOFT;
        productListPage.saleRibbonForCampaignItemIsDisplayed().shouldBe(visible);
    }

    @Description("This test checks that we can open PDP from 'Most Popular' section")
    @Test(description = "Open product detail page")
    public void openPDPFromMostPopularSectionTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productListPage.openPDP();

        productDetailPage.getAddToCartButtonText().shouldBe(visible);
    }

    @Description("This test checks the possibility to add items to the cart")
    @Test(description = "Add item to cart")
    public void addToCartTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productListPage.openPDP();
        productDetailPage.addToCart();

        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(productDetailPage.getCartItemsQuantity(), "1"));

        productDetailPage.getCartItemsQuantityText().shouldHave(text("1"));
    }

}