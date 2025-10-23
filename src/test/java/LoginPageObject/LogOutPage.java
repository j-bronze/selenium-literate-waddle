package LoginPageObject;

import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static TestBase.Locators.getLocator;

public class LogOutPage extends TestBase {

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut() throws Exception {
        List<WebElement> listOfLinks = driver.findElements(getLocator("LogOutPage.LogOutLink"));
        listOfLinks.get(3).click();
    }

}