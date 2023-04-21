package utilitiesLibrary;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BrowserUtils {
    public static void staticWait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setWaitTime() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public static void selectFromDropdown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
        setWaitTime();
    }

    public static void clickWithWait(WebElement webElement) {
        // Fluent wait is a type of explicit wait, however with the polling frequency defined
        Wait wait = new FluentWait(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(15)) // wait for 15 seconds
                .pollingEvery(Duration.ofMillis(800)) // polling: check WebElement visibility every x amount of seconds
                // which exceptions should be ignored by this wait while it is active:
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);
        WebElement element = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);

        try {
            element.click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }

        setWaitTime();
    }

    public static void waitForPageToLoad(long timeOutSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
}
