import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class SeleniumTest {

    @Test
    public void clickOn1MenuTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement navBarMenu = driver.findElement(By.cssSelector("nav#site-menu li[class='category-1']"));
        navBarMenu.click();

        String pageTitle = driver.findElement(By.cssSelector("div#box-category h1[class='title']")).getText();
        Assert.assertEquals(pageTitle, "Rubber Ducks");
    }

    @Test
    public void clickOn2MenuItemTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement navBarMenu = driver.findElement(By.cssSelector("nav#site-menu li[class='category-1']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        actions.moveToElement(navBarMenu);
        WebElement menuItem = driver.findElement(By.cssSelector("nav#site-menu ul li[class='category-2']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(menuItem).click().perform();

        String pageTitle = driver.findElement(By.cssSelector("div#box-category h1[class='title']")).getText();
        Assert.assertEquals(pageTitle, "Subcategory");
    }

    @Test
    public void clickOn3HomeIconTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement navBarHomeIcon = driver.findElement(By.cssSelector("i[title='Home']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navBarHomeIcon.click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "");

        
        }
}
