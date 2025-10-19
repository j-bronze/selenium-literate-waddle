package LoginPageObject;

import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    @Test
    public void loginUsingCorrectCredentialsTest() {
        LoginPageObject.LoginPage loginPage = new LoginPage(driver);
        LoginPageObject.LoginResultPage loginResultPage = new LoginResultPage(driver);

        loginPage.login("paftut@mailto.plus", "111111a");

        Assert.assertEquals(loginResultPage.getSuccessLoggingOnMessageText(), "You are now logged in as Alex Besson.");
    }

    @Test
    public void loginWithoutPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        LoginResultPage loginResultPage = new LoginResultPage(driver);

        loginPage.enterLogin("paftut@mailto.plus");
        loginPage.clickButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.errorMessageIsVisible());
        softAssert.assertEquals(loginResultPage.getErrorMessageText(), "You must provide both email address and password.");
        softAssert.assertAll();
    }

    @Test
    public void logOutTest() {
        LoginPage loginPage = new LoginPage(driver);
        LoginResultPage loginResultPage = new LoginResultPage(driver);

        loginPage.login("paftut@mailto.plus", "111111a");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.successLoggingOnMessageIsVisible());

        LogOutPage logOutPage = new LogOutPage(driver);
        logOutPage.logOut();

        softAssert.assertTrue(loginResultPage.successLogOutMessageIsVisible());
        softAssert.assertEquals(loginResultPage.getSuccessLogOutMessageText(), "You are now logged out.");
        softAssert.assertAll();
    }

}