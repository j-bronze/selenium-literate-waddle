package SelenideProject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;

import java.util.List;

import static SelenideProject.Locators.getLocator;

public class LogOutPage extends TestBase {

    public void logOut() throws Exception {
        List<WebElement> listOfLinks = WebDriverRunner.getWebDriver().findElements(getLocator("LogOutPage.LogOutLink"));
        listOfLinks.get(3).click();
    }

}