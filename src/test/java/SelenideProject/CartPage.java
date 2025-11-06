package SelenideProject;

import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends TestBase {

    public void openCart() throws Exception {
        $(getLocator("CartPage.Cart")).click();
    }

}