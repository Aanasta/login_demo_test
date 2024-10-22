package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static utils.PropertiesUtil.getPassword;
import static utils.PropertiesUtil.getUsername;

public class LoginPageTest extends BaseTest {

    @Test
    public void testLoginIsSuccessful() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        HomePage homePage = loginPage.loginWithCredentials(getUsername(), getPassword());

        Assert.assertTrue(homePage.isSuccessMessageDisplayed(), "Success message is not displayed for valid user");
        Assert.assertEquals(homePage.getSuccessMessageText(), "Login successful", "Success message text is not as expected");
    }
}
