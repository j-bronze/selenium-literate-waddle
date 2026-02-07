package ProductPageObject;

import TestBase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest extends TestBase {

    @Test
    public void saleRibbonForCampaignItemTest() throws Exception {
        ProductListPage productListPage = new ProductListPage(driver);

        productListPage.saleRibbonForCampaignItemIsDisplayed();

        Assert.assertTrue(productListPage.saleRibbonForCampaignItemIsDisplayed());
    }

    @Test
    public void openPDPFromMostPopularSectionTest() throws Exception {
        ProductListPage productListPage = new ProductListPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productListPage.openPDP();

        Assert.assertEquals(productDetailPage.getAddToCartButtonText(), "Add To Cart");
    }

    @Test
    public void addToCartTest() throws Exception {
        ProductListPage productListPage = new ProductListPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productListPage.openPDP();
        productDetailPage.addToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(productDetailPage.getCartItemsQuantity(), "1"));

        Assert.assertEquals(productDetailPage.getCartItemsQuantityText(), "1");
    }

}