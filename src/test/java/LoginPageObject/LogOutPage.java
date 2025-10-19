package LoginPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LogOutPage extends TestBase {

    private final By logOutLink = new By.ByCssSelector("div#box-account li a");

    private WebDriver driver;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut() {
        List<WebElement> listOfLinks = driver.findElements(logOutLink);
        listOfLinks.get(3).click();
    }

}