package core.helpers.alert;

import core.helpers.logger.MyLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper
{
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(AlertHelper.class);
    //=============================================================//
    public AlertHelper(WebDriver driver)
    {
        this.driver = driver;
        log.info("AlertHelper object is created..");
    }
    //=============================================================//
    public Alert getAlert()
    {
        log.info("Alert test: " + driver.switchTo().alert().getText());
        return driver.switchTo().alert();
    }
    //=============================================================//
    public void ecceptAlert()
    {
        getAlert().accept();
        log.info("Accept Alert is done..");
    }
    //=============================================================//
    public void dismissAlert()
    {
        getAlert().dismiss();
        log.info("Dismiss Alert is done..");
    }
    //=============================================================//
    public String getAlertText()
    {
        String text = getAlert().getText();
        log.info("Alert test: " + text);
        return text;
    }
    //=============================================================//
    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            log.info("Alert is present..");
            return true;
        }
        catch (NoAlertPresentException e)
        {
            log.info(e.getCause());
            return false;
        }
    }
    //=============================================================//
    public void ecceptAlertIfPresent()
    {
        if(isAlertPresent())
        {
            ecceptAlert();
        }
        else
        {
            log.info("Alert is not present..");
        }
    }
    //=============================================================//
    public void dismissAlertIfPresent()
    {
        if(isAlertPresent())
        {
            dismissAlert();
        }
        else
        {
            log.info("Alert is not present..");
        }
    }
    //=============================================================//
    public void ecceptPromt(String text)
    {
        if(isAlertPresent())
        {
            Alert alert = getAlert();
            alert.sendKeys(text);
            alert.accept();
            log.info("Alert text: " + text);
        }
    }
    //=============================================================//
}
