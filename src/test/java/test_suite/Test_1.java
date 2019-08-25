package test_suite;

import core.helpers.assertion.AssertionHelper;
import core.helpers.logger.MyLogger;
import core.helpers.resource.ResourceHelper;
import core.test_base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test_1 extends TestBase
{
    private Logger log = MyLogger.getLogger(Test_1.class);
    public static File reportDirectory = new File(ResourceHelper.getRecoursePath("\\src\\main\\java\\core\\screenshots"));

    @Test
    public void goToGoogle() throws InterruptedException
    {
        driver.get("http://google.com");
        Thread.sleep(5000);
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToFacebook() throws InterruptedException
    {
        driver.get("http://facebook.com");
        Thread.sleep(5000);
        AssertionHelper.makeFalse();
    }

    @Test
    public void goToYahoo() throws InterruptedException
    {
        driver.get("http://yahoo.com");
        Thread.sleep(5000);
        AssertionHelper.makeFalse();
    }

    @Test
    public void goToYouTube() throws InterruptedException
    {
        driver.get("http://youtube.com");
        Thread.sleep(5000);
        AssertionHelper.makeTrue();
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    //====================================================================//

    //====================================================================//
}
