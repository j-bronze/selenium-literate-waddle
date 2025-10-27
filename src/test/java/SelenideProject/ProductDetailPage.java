package SelenideProject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailPage extends TestBase {

    public By getCartItemsQuantity() throws Exception {
        return getLocator("ProductDetailPage.CartItemsQuantity");
    }

    public void addToCart() throws Exception {
        $(getLocator("ProductDetailPage.AddToCartButton")).click();
    }

    public SelenideElement getAddToCartButtonText() throws Exception {
        return $(getLocator("ProductDetailPage.AddToCartButton"));
    }

    public SelenideElement getCartItemsQuantityText() throws Exception {
        return $(getLocator("ProductDetailPage.CartItemsQuantity"));
    }
}