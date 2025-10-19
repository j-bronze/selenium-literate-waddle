package ProductPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage extends TestBase {

    private final By productItem = By.cssSelector("div#box-most-popular li a");
    private final By ribbonSale = By.cssSelector("div#box-campaigns div[class='sticker sale']");

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getProductItem() {
        return productItem;
    }

    public By getRibbonSale() {
        return ribbonSale;
    }

    public void openPDP() {
        List<WebElement> listOfItems = driver.findElements(productItem);
        listOfItems.getFirst().click();
    }

    public boolean saleRibbonForCampaignItemIsDisplayed() {
        return driver.findElement(ribbonSale).isDisplayed();
    }

}