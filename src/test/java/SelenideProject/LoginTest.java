package SelenideProject;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Epic("Authorization")
@Feature("LogIn and LogOut")
public class LoginTest extends TestBase {

    @Description("Using correct credentials to login")
    @Test(description = "Login with correct credentials")
    public void loginUsingCorrectCredentialsTest() throws Exception {
        SelenideProject.LoginPage loginPage = new LoginPage();
        SelenideProject.LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.login("paftut@mailto.plus", "111111a");

        Configuration.assertionMode = AssertionMode.SOFT;
        loginResultPage.getSuccessLoggingOnMessageText().shouldBe(visible)
                .shouldHave(text("You are now logged in as Alex Besson."));
    }

    @Description("This test checks if it is impossible to log in without a password")
    @Test(description = "Enter only login, the password field is left blank")
    public void loginWithoutPasswordTest() throws Exception {
        LoginPage loginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.enterLogin("paftut@mailto.plus");
        loginPage.clickButton();

        loginResultPage.getErrorMessageText().shouldBe(visible)
                .shouldHave(text("You must provide both email address and password."));
    }

    @Description("This test checks logging off")
    @Test(description = "Click on link to logout")
    public void logOutTest() throws Exception {
        LoginPage loginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.login("paftut@mailto.plus", "111111a2");

        loginResultPage.getSuccessLoggingOnMessageText().shouldBe(visible);

        LogOutPage logOutPage = new LogOutPage();
        logOutPage.logOut();

        loginResultPage.getSuccessLogOutMessageText().shouldBe(visible).shouldHave(text("You are now logged out."));
    }

}