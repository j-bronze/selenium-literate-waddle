package SelenideProject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import listeners.ScreenshotListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenshotListener.class, SoftAsserts.class})
public class TestBase {

    @BeforeMethod
    public void setup() {
        Configuration.browser = CHROME;
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";

        open("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        closeWebDriver();
    }

}