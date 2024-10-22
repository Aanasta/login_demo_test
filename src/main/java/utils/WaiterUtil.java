package utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaiterUtil {

    private static final int STANDARD_TIMEOUT = 2;

    private WebDriver driver;

    public WaiterUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToBePresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(STANDARD_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(STANDARD_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementPresent(WebElement element) {
        try {
            waitForElementToBePresent(element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
