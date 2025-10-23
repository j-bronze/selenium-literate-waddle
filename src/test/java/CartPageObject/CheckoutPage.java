package CartPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static TestBase.Locators.getLocator;

public class CheckoutPage extends TestBase {

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getCartWithGoods() throws Exception {
        return getLocator("CheckoutPage.CartWithGoods");
    }

    public By getCartEmpty() throws Exception {
        return getLocator("CheckoutPage.CartEmpty");
    }

    public boolean cartWithGoodsIsOpened() throws Exception {
        return driver.findElement(getLocator("CheckoutPage.CartWithGoods")).isDisplayed();
    }

    public boolean cartEmptyIsOpened() throws Exception {
        return driver.findElement(getLocator("CheckoutPage.CartEmpty")).isDisplayed();
    }

    public boolean cartEmptyMessageIsDisplayed() throws Exception {
        return driver.findElement(getLocator("CheckoutPage.CartEmptyMessage")).isDisplayed();
    }

    public String getCartEmptyMessage() throws Exception {
        return driver.findElement(getLocator("CheckoutPage.CartEmptyMessage")).getText();
    }

}