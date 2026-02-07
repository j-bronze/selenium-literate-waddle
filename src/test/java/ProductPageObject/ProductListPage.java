package ProductPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static TestBase.Locators.getLocator;

public class ProductListPage extends TestBase {

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getProductItem() throws Exception {
        return getLocator("ProductListPage.ProductItem");
    }

    public By getRibbonSale() throws Exception {
        return getLocator("ProductListPage.RibbonSale");
    }

    public void openPDP() throws Exception {
        List<WebElement> listOfItems = driver.findElements(getLocator("ProductListPage.ProductItem"));
        listOfItems.getFirst().click();
    }

    public boolean saleRibbonForCampaignItemIsDisplayed() throws Exception {
        return driver.findElement(getLocator("ProductListPage.RibbonSale")).isDisplayed();
    }

}