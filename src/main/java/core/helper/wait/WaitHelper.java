package core.helper.wait;

import core.helper.logger.MyLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper
{
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(WaitHelper.class);
    //====================================================================//

    /**
     * constructor will help us to initiate webDriver object
     * @param driver
     */
    public WaitHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * This is ImplicitlyWait method
     * @param timeout
     * @param unit
     */
    //====================================================================//
    public void setImpicitWait(long timeout, TimeUnit unit)
    {
        log.info("Implicit Wait has been set to: " + timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }

    /**
     * This is will help us to get WebDriverWait object
     * @param timeOutInSeconds
     * @param pollingEveryInMilisec
     * @return
     */
    //====================================================================//
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMilisec )
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMilisec));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    /**
     * This method will make sure element is visible
     * @param element
     * @param timeOutInSeconds
     * @param pollingEveryMiliSec
     */
    //====================================================================//
    public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryMiliSec)
    {
        log.info("Wating for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryMiliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is visible now");
    }

    /**
     * This method will make sure element is clickable
     * @param element
     * @param timeOutInSeconds
     */
    //====================================================================//
    public void WaitForElementClickable(WebElement element, int timeOutInSeconds)
    {
        log.info("Wating for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element is clickable now");
    }

    /**
     * This method will make sure element invisibility of element
     * @param element
     * @param timeOutInSeconds
     * @return
     */
    //====================================================================//
    public boolean WaitForElementNotPresent(WebElement element, long timeOutInSeconds)
    {
        log.info("Wating for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("Element is invisible now");
        return status;
    }

    /**
     * This method will for frameToBeAvailableAndSwitchToIt
     * @param element
     * @param timeOutInSeconds
     */
    //====================================================================//
    public void WaitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds)
    {
        log.info("Wating for : " + element.toString() + " for : " + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("Frame is available and switched now");
    }

    /**
     * This method will give us fluentWait object
     * @param timeOutInSeconds
     * @param polingEveryIntMiliSec
     * @return
     */
    //====================================================================//
    private Wait<WebDriver> getFluentWait(int timeOutInSeconds, int polingEveryIntMiliSec)
    {
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
        .pollingEvery(Duration.ofMillis(polingEveryIntMiliSec)).ignoring(NoSuchElementException.class);
        return fWait;
    }

    /**
     *This element will help us to for element appearance
     * @param element
     * @param timeOutInSeconds
     * @param polingEveryInMiliSec
     * @return
     */
    //====================================================================//
    public WebElement waitForElement(WebElement element, int timeOutInSeconds, int polingEveryInMiliSec)
    {
        getFluentWait(timeOutInSeconds, timeOutInSeconds);
        Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds, polingEveryInMiliSec);
        //fwait.until(ExpectedConditions.elementToBeClickable(element));
        fwait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    //====================================================================//

    /**
     * This metod will help us to
     * @param timeout
     * @param unit
     */
    public void pageLoadTime(long timeout, TimeUnit unit)
    {
        log.info("Waiting for page to load for : " + unit + " seconds");
        driver.manage().timeouts().pageLoadTimeout(timeout, unit);
        log.info("Page is loaded");
    }

}
