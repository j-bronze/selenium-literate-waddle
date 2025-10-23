package SelenideProject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest extends TestBase {

    @Test
    public void saleRibbonForCampaignItemTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();

        productListPage.saleRibbonForCampaignItemIsDisplayed();

        Assert.assertTrue(productListPage.saleRibbonForCampaignItemIsDisplayed());
    }

    @Test
    public void openPDPFromMostPopularSectionTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productListPage.openPDP();

        Assert.assertEquals(productDetailPage.getAddToCartButtonText(), "Add To Cart");
    }

    @Test
    public void addToCartTest() throws Exception {
        ProductListPage productListPage = new ProductListPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productListPage.openPDP();
        productDetailPage.addToCart();

        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(productDetailPage.getCartItemsQuantity(), "1"));

        Assert.assertEquals(productDetailPage.getCartItemsQuantityText(), "1");
    }

}
