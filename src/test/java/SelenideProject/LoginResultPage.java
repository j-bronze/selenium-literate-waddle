package SelenideProject;

import com.codeborne.selenide.SelenideElement;

import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class LoginResultPage extends TestBase {

    public SelenideElement getErrorMessageText() throws Exception {
        return $(getLocator("LoginResultPage.ErrorMessage"));
    }

    public SelenideElement getSuccessLoggingOnMessageText() throws Exception {
        return $(getLocator("LoginResultPage.SuccessLoggingOnMessage"));
    }

    public SelenideElement getSuccessLogOutMessageText() throws Exception {
        return $(getLocator("LoginResultPage.SuccessLogOutMessage"));
    }
}