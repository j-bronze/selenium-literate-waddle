package CartPageObject;

import TestBase.TestBase;
import org.openqa.selenium.WebDriver;

import static TestBase.Locators.getLocator;

public class CartPage extends TestBase {

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() throws Exception {
        driver.findElement(getLocator("CartPage.Cart")).click();
    }

}
