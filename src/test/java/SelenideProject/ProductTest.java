package SelenideProject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class ProductTest extends TestBase {

    @Test
    public void saleRibbonForCampaignItemTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();

        productListPage.saleRibbonForCampaignItemIsDisplayed();

        productListPage.saleRibbonForCampaignItemIsDisplayed().shouldBe(visible);
    }

    @Test
    public void openPDPFromMostPopularSectionTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productListPage.openPDP();

        productDetailPage.getAddToCartButtonText().shouldBe(visible);
    }

    @Test
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
