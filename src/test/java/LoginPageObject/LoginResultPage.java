package LoginPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginResultPage extends TestBase {

    private final By successLoggingOnMessage = By.cssSelector("div.notice.success");
    private final By successLogOutMessage = By.cssSelector("div.notice.success");
    private final By errorMessage = By.cssSelector("div.notice.errors");
    private WebDriver driver;

    public LoginResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean errorMessageIsVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean successLoggingOnMessageIsVisible() {
        return driver.findElement(successLoggingOnMessage).isDisplayed();
    }

    public String getSuccessLoggingOnMessageText() {
        return driver.findElement(successLoggingOnMessage).getText();
    }

    public boolean successLogOutMessageIsVisible() {
        return driver.findElement(successLogOutMessage).isDisplayed();
    }

    public String getSuccessLogOutMessageText() {
        return driver.findElement(successLogOutMessage).getText();
    }

}