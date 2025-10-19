package LoginPageObject;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends TestBase {

    private final By loginInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.name("login");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLogin(String username) {
        driver.findElement(loginInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterLogin(username);
        enterPassword(password);
        clickButton();
    }

}