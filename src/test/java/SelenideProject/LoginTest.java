package SelenideProject;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    @Test
    public void loginUsingCorrectCredentialsTest() throws Exception {
        SelenideProject.LoginPage loginPage = new LoginPage();
        SelenideProject.LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.login("paftut@mailto.plus", "111111a");

        Assert.assertEquals(loginResultPage.getSuccessLoggingOnMessageText(), "You are now logged in as Alex Besson.");
    }

    @Test
    public void loginWithoutPasswordTest() throws Exception {
        LoginPage loginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.enterLogin("paftut@mailto.plus");
        loginPage.clickButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.errorMessageIsVisible());
        softAssert.assertEquals(loginResultPage.getErrorMessageText(), "You must provide both email address and password.");
        softAssert.assertAll();
    }

    @Test
    public void logOutTest() throws Exception {
        LoginPage loginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.login("paftut@mailto.plus", "111111a");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.successLoggingOnMessageIsVisible());

        LogOutPage logOutPage = new LogOutPage();
        logOutPage.logOut();

        softAssert.assertTrue(loginResultPage.successLogOutMessageIsVisible());
        softAssert.assertEquals(loginResultPage.getSuccessLogOutMessageText(), "You are now logged out.");
        softAssert.assertAll();
    }

}