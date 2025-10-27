package SelenideProject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import listeners.ScreenshotListener;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenshotListener.class, SoftAsserts.class})
public class TestBase {

    @BeforeMethod
    public void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        String browser = System.getProperty("browser", "chrome");
        String os = System.getProperty("os", "win");

        switch (browser) {
            case "chrome" -> caps.setBrowserName(CHROME);
            case "safari" -> caps.setBrowserName(SAFARI);
            case "firefox" -> caps.setBrowserName(FIREFOX);
            case "edge" -> caps.setBrowserName(EDGE);
        };
        switch (os){
            case "win11" -> caps.setPlatform(Platform.WIN11);
            case "win" -> caps.setPlatform(Platform.WINDOWS);
            case "linux" -> caps.setPlatform(Platform.LINUX);
            case "mac" -> caps.setPlatform(Platform.MAC);
        };

        Configuration.remote = "http://192.168.100.4:4444/wd/hub";
        Configuration.browserCapabilities = caps;

        open("https://litecart.stqa.ru/en/");

    }

    @AfterMethod
    public void teardown() {
        closeWebDriver();
    }

}