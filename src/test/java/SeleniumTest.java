import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    @Test
    public void registrationLinkTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#box-account-login")));
        WebElement registrationLink = driver.findElement(By.cssSelector("div#box-account-login tr td a"));
        registrationLink.click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Create Account | My Store");
    }

    @Test
    public void loggingOnTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#box-account-login")));

        WebElement loginInput = driver.findElement(By.cssSelector("input[type='text']"));
        String email = "paftut@mailto.plus";
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        String password = "111111a";
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("span[class='button-set'] button[name='login']"));
        loginButton.click();

        String loggingOn = driver.findElement(By.cssSelector("div#box-account h3[class='title']")).getText();
        Assert.assertEquals(loggingOn, "Account");

        driver.quit();
    }

    @Test
    public void loginWithoutPasswordTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#box-account-login")));

        WebElement loginInput = driver.findElement(By.cssSelector("input[type='text']"));
        String email = "paftut@mailto.plus";
        loginInput.sendKeys(email);

        WebElement loginButton = driver.findElement(By.cssSelector("span[class='button-set'] button[name='login']"));
        loginButton.click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Login | My Store");

        driver.quit();
    }

    @Test
    public void loggingOffTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#box-account-login")));

        WebElement loginInput = driver.findElement(By.cssSelector("input[type='text']"));
        String email = "paftut@mailto.plus";
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        String password = "111111a";
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("span[class='button-set'] button[name='login']"));
        loginButton.click();

        String loggingOn = driver.findElement(By.cssSelector("div#box-account h3[class='title']")).getText();
        Assert.assertEquals(loggingOn, "Account");

        List<WebElement> listOfLinks = driver.findElements(By.cssSelector("div#box-account li a"));
        listOfLinks.get(3).click();

        String loggingOff = driver.findElement(By.cssSelector("div#box-account-login h3[class='title']")).getText();
        Assert.assertEquals(loggingOff, "Login");

        driver.quit();
    }

    @Test
    public void saleRibbonForCampaignItemTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#box-campaigns")));

        String ribbonText = driver.findElement(By.cssSelector("div#box-campaigns div[class='sticker sale']")).getText();
        Assert.assertEquals(ribbonText, "SALE");

        driver.quit();
    }

    @Test
    public void openPDPFromMostPopularSectionTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(20)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#box-most-popular")));

        List<WebElement> listOfItems = driver.findElements(By.cssSelector("div#box-most-popular li a"));
        listOfItems.getFirst().click();

        String buttonText = driver.findElement(By.cssSelector("div#box-product button[name='add_cart_product']")).getText();
        Assert.assertEquals(buttonText, "Add To Cart");

        driver.quit();
    }

    @Test
    public void addToCartTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/green-duck-p-2");
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#box-product")));
        WebElement buttonAddToCart = driver.findElement(By.cssSelector("div#box-product button[name='add_cart_product']"));
        buttonAddToCart.click();

        String expectedQuantity = "1";
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div#cart span[class='quantity']"), expectedQuantity));

        String totalPriceText = driver.findElement(By.cssSelector("div#cart span[class='formatted_value']")).getText();
        Assert.assertEquals(totalPriceText, "$20");

        driver.quit();
    }

    @Test
    public void openEmptyCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#cart")));

        WebElement cart = driver.findElement(By.cssSelector("div#cart"));
        cart.click();

        String cartEmptyPageText = driver.findElement(By.cssSelector("div#checkout-cart-wrapper em")).getText();
        Assert.assertEquals(cartEmptyPageText, "There are no items in your cart.");
        driver.quit();
    }

    @Test
    public void openCartWithItemsTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/blue-duck-p-4");
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#box-product")));

        WebElement buttonAddToCart = driver.findElement(By.cssSelector("div#box-product button[name='add_cart_product']"));
        buttonAddToCart.click();

        WebElement cart = driver.findElement(By.cssSelector("div#cart"));
        cart.click();

        String itemName = driver.findElement(By.cssSelector("div#box-checkout-cart strong")).getText();
        Assert.assertEquals(itemName, "Blue Duck");
        driver.quit();
    }

}
