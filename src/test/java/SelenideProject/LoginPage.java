package SelenideProject;

import io.qameta.allure.Step;

import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends TestBase {

    @Step("Enter login")
    public void enterLogin(String username) throws Exception {
        $(getLocator("LoginPage.LoginInput")).sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) throws Exception {
        $(getLocator("LoginPage.PasswordInput")).sendKeys(password);
    }

    @Step("Click on login button")
    public void clickButton() throws Exception {
        $(getLocator("LoginPage.LoginButton")).click();
    }

    public void login(String username, String password) throws Exception {
        enterLogin(username);
        enterPassword(password);
        clickButton();
    }

}