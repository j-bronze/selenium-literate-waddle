package SelenideProject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class ProductListPage extends TestBase {

    public By getProductItem() throws Exception {
        return getLocator("ProductListPage.ProductItem");
    }

    public By getRibbonSale() throws Exception {
        return getLocator("ProductListPage.RibbonSale");
    }

    public void openPDP() throws Exception {
        List<WebElement> listOfItems = WebDriverRunner.getWebDriver().findElements(getLocator("ProductListPage.ProductItem"));
        listOfItems.getFirst().click();
    }

    public boolean saleRibbonForCampaignItemIsDisplayed() throws Exception {
        return $(getLocator("ProductListPage.RibbonSale")).isDisplayed();
    }

}