package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement loginMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        return getWaiter().isElementPresent(loginMessage);
    }

    public String getSuccessMessageText() {
        return getWaiter().waitForElementToBePresent(loginMessage).getText();
    }
}
