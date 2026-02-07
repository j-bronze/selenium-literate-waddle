package SelenideProject;

import com.codeborne.selenide.SelenideElement;

import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends TestBase {

    public SelenideElement cartWithGoodsIsOpened() throws Exception {
        return $(getLocator("CheckoutPage.CartWithGoods"));
    }

    public SelenideElement getCartEmptyMessage() throws Exception {
        return $(getLocator("CheckoutPage.CartEmptyMessage"));
    }
}