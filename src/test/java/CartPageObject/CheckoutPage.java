package CartPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final By cartWithGoods = By.cssSelector("div#box-checkout-customer h2[class='title']");
    private final By cartEmpty = By.cssSelector("div#checkout-cart-wrapper");
    private final By cartEmptyMessage = By.cssSelector("div#checkout-cart-wrapper em");

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getCartWithGoods() {
        return cartWithGoods;
    }

    public By getCartEmpty() {
        return cartEmpty;
    }

    public boolean cartWithGoodsIsOpened() {
        return driver.findElement(cartWithGoods).isDisplayed();
    }

    public boolean cartEmptyIsOpened() {
        return driver.findElement(cartEmpty).isDisplayed();
    }

    public boolean cartEmptyMessageIsDisplayed() {
        return driver.findElement(cartEmptyMessage).isDisplayed();
    }

    public String getCartEmptyMessage() {
        return driver.findElement(cartEmptyMessage).getText();
    }

}