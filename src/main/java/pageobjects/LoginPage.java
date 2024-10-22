package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesUtil;

public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;
    @FindBy(id = "login_btn")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        driver.get(PropertiesUtil.getBaseUrl());
        return new LoginPage(driver);
    }

    public HomePage loginWithCredentials(String username, String password) {
        getWaiter().waitForElementToBePresent(emailInput).sendKeys(username);
        getWaiter().waitForElementToBePresent(passwordInput).sendKeys(password);
        getWaiter().waitForElementToBeClickable(signInButton).click();
        return new HomePage(driver);
    }
}
