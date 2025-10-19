package CartPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends TestBase {

    private final By cart = By.id("cart");

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cart).click();
    }

}
