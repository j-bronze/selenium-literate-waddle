package SelenideProject;

import static SelenideProject.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends TestBase {

    public void enterLogin(String username) throws Exception {
        $(getLocator("LoginPage.LoginInput")).sendKeys(username);
    }

    public void enterPassword(String password) throws Exception {
        $(getLocator("LoginPage.PasswordInput")).sendKeys(password);
    }

    public void clickButton() throws Exception {
        $(getLocator("LoginPage.LoginButton")).click();
    }

    public void login(String username, String password) throws Exception {
        enterLogin(username);
        enterPassword(password);
        clickButton();
    }

}