package SelenideProject;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeMethod
    public void setup() {
        Configuration.browser = CHROME;
        Configuration.pageLoadTimeout = 5000;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";

        open("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        closeWebDriver();
    }

}