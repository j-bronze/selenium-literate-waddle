package SelenideProject;

import org.openqa.selenium.By;
import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailPage extends TestBase {

    public By getCartItemsQuantity() throws Exception {
        return getLocator("ProductDetailPage.CartItemsQuantity");
    }

    public By getAddToCartButton() throws Exception {
        return getLocator("ProductDetailPage.AddToCartButton");
    }

    public void addToCart() throws Exception {
        $(getLocator("ProductDetailPage.AddToCartButton")).click();
    }

    public String getAddToCartButtonText() throws Exception {
        return $(getLocator("ProductDetailPage.AddToCartButton")).getText();
    }

    public String getCartItemsQuantityText() throws Exception {
        return $(getLocator("ProductDetailPage.CartItemsQuantity")).getText();
    }

}