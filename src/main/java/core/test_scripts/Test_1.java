package core.test_scripts;

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

//    private WebDriver driver;
//    private Logger log = MyLogger.getLogger(Test_1.class);
//    public static File reportDirectory = new File(ResourceHelper.getRecoursePath("\\src\\main\\java\\core\\screenshots"));

//    @BeforeTest
//    public void setUp()
//    {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }

    @Test
    public void goToGoogle() throws InterruptedException
    {
        driver.get("http://google.com");
        captureScreenShot("Google page", driver);
        Thread.sleep(5000);
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToFacebook() throws InterruptedException
    {
        driver.get("http://facebook.com");
        captureScreenShot("Facebook page", driver);
        Thread.sleep(5000);
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToYahoo() throws InterruptedException
    {
        driver.get("http://yahoo.com");
        captureScreenShot("Yahoo page", driver);
        Thread.sleep(5000);
        AssertionHelper.makeTrue("We are on the Yahoo page ... ");
    }

    @Test
    public void goToYouTube() throws InterruptedException
    {
        driver.get("http://youtube.com");
        captureScreenShot("Youtube page", driver);
        Thread.sleep(5000);
        AssertionHelper.makeTrue();
    }
    //====================================================================//
//    public  String captureScreenShot(String fileName)
//    {
//        if(driver == null)
//        {
//            log.info("Driver is null...");
//            return null;
//        }
//        if (fileName == "")
//        {
//            fileName = "blank";
//        }
//        File destFile = null;
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//        File screnshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try
//        {
//            destFile = new File(reportDirectory + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
//            FileUtils.copyFile(screnshotFile, destFile);
//            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "'height='100' width='100'/></a>");
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return destFile.toString();
//
//    }
    //====================================================================//
}
