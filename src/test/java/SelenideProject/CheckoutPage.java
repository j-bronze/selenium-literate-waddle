package SelenideProject;

import org.openqa.selenium.By;

import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends TestBase {

    public By getCartWithGoods() throws Exception {
        return getLocator("CheckoutPage.CartWithGoods");
    }

    public By getCartEmpty() throws Exception {
        return getLocator("CheckoutPage.CartEmpty");
    }

    public boolean cartWithGoodsIsOpened() throws Exception {
        return $(getLocator("CheckoutPage.CartWithGoods")).isDisplayed();
    }

    public boolean cartEmptyIsOpened() throws Exception {
        return $(getLocator("CheckoutPage.CartEmpty")).isDisplayed();
    }

    public boolean cartEmptyMessageIsDisplayed() throws Exception {
        return $(getLocator("CheckoutPage.CartEmptyMessage")).isDisplayed();
    }

    public String getCartEmptyMessage() throws Exception {
        return $(getLocator("CheckoutPage.CartEmptyMessage")).getText();
    }

}