package SelenideProject;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class LoginTest extends TestBase {

    @Test
    public void loginUsingCorrectCredentialsTest() throws Exception {
        SelenideProject.LoginPage loginPage = new LoginPage();
        SelenideProject.LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.login("paftut@mailto.plus", "111111a");

        loginResultPage.getSuccessLoggingOnMessageText().shouldBe(visible)
                .shouldHave(text("You are now logged in as Alex Besson."));
    }

    @Test
    public void loginWithoutPasswordTest() throws Exception {
        LoginPage loginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.enterLogin("paftut@mailto.plus");
        loginPage.clickButton();

        loginResultPage.getErrorMessageText().shouldBe(visible)
                .shouldHave(text("You must provide both email address and password."));

    }

    @Test
    public void logOutTest() throws Exception {
        LoginPage loginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.login("paftut@mailto.plus", "111111a");

        loginResultPage.getSuccessLoggingOnMessageText().shouldBe(visible);

        LogOutPage logOutPage = new LogOutPage();
        logOutPage.logOut();

        loginResultPage.getSuccessLogOutMessageText().shouldBe(visible).shouldHave(text("You are now logged out."));
    }

}