package SelenideProject;

import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class LoginResultPage extends TestBase {

    public boolean errorMessageIsVisible() throws Exception {
        return $(getLocator("LoginResultPage.ErrorMessage")).isDisplayed();
    }

    public String getErrorMessageText() throws Exception {
        return $(getLocator("LoginResultPage.ErrorMessage")).getText();
    }

    public boolean successLoggingOnMessageIsVisible() throws Exception {
        return $(getLocator("LoginResultPage.SuccessLoggingOnMessage")).isDisplayed();
    }

    public String getSuccessLoggingOnMessageText() throws Exception {
        return $(getLocator("LoginResultPage.SuccessLoggingOnMessage")).getText();
    }

    public boolean successLogOutMessageIsVisible() throws Exception {
        return $(getLocator("LoginResultPage.SuccessLogOutMessage")).isDisplayed();
    }

    public String getSuccessLogOutMessageText() throws Exception {
        return $(getLocator("LoginResultPage.SuccessLogOutMessage")).getText();
    }

}