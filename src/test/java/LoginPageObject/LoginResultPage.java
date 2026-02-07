package LoginPageObject;

import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import static TestBase.Locators.getLocator;

public class LoginResultPage extends TestBase {

    public LoginResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean errorMessageIsVisible() throws Exception {
        return driver.findElement(getLocator("LoginResultPage.ErrorMessage")).isDisplayed();
    }

    public String getErrorMessageText() throws Exception {
        return driver.findElement(getLocator("LoginResultPage.ErrorMessage")).getText();
    }

    public boolean successLoggingOnMessageIsVisible() throws Exception {
        return driver.findElement(getLocator("LoginResultPage.SuccessLoggingOnMessage")).isDisplayed();
    }

    public String getSuccessLoggingOnMessageText() throws Exception {
        return driver.findElement(getLocator("LoginResultPage.SuccessLoggingOnMessage")).getText();
    }

    public boolean successLogOutMessageIsVisible() throws Exception {
        return driver.findElement(getLocator("LoginResultPage.SuccessLogOutMessage")).isDisplayed();
    }

    public String getSuccessLogOutMessageText() throws Exception {
        return driver.findElement(getLocator("LoginResultPage.SuccessLogOutMessage")).getText();
    }

}