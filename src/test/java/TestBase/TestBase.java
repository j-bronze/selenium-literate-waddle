package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected final String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}