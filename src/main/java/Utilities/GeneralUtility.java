package Utilities;


import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class GeneralUtility {

    private static final String ScreenShoot_Path = "test-outputs/Screenshots/";

    //TODO: create a click on element method
    public static void Click_OnElement(WebDriver driver, By locator) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait handles retries internally — no loop needed
            element = wait
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(ElementClickInterceptedException.class)
                    .until(ExpectedConditions.elementToBeClickable(locator));

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});", element);

            // Wait again after scroll — element may go stale after scrollIntoView
            element = wait
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(ElementClickInterceptedException.class)
                    .until(ExpectedConditions.elementToBeClickable(locator));

            element.click();

        } catch (ElementClickInterceptedException e) {
            // JS click fallback — re-find fresh to avoid stale
            element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", element);

        } catch (Exception e) {
            GeneralUtility.lastFailedElement = element;
            throw e;
        }
    }

    //TODO: create a Send Data method
    public static void SendData(WebDriver driver, By locator, String dataToBeSend) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            element = wait.until(ExpectedConditions.elementToBeClickable(locator));

            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.DELETE);
            element.sendKeys(dataToBeSend);

        } catch (Exception e) {
            GeneralUtility.lastFailedElement = element; // save failed element
            throw e;
        }
    }

    //TODO: create a Get Text method
    public static String GetText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }


    //TODO: create a General Wait method
    public static WebDriverWait GeneralWait(WebDriver driver, int Seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(Seconds));
    }

    //TODO: create a Wait for element method
    public static void waitForElement(WebDriver driver, By category) {
        // Wait until the element is visible
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(category));

        // Wait until the element is clickable
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(category)).click();
    }

    //TODO: create a Get Time Stamp method
    public static String GetTimeStamp() {

        return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ssa").format(new Date());
    }

    //TODO: create a ScreenShot method
    public static WebElement lastFailedElement = null;
}



