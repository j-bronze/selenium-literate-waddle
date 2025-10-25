import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void seleniumTestOpenBrowser() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

        List<WebElement> listOfLinks = driver.findElements(By.cssSelector("a"));

        Assert.assertEquals(listOfLinks.size(), 46);

        listOfLinks.get(10).click();;
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
