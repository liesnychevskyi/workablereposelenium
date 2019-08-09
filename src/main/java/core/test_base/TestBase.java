package core.test_base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import core.helpers.browser_configurations.BrowserType;
import core.helpers.browser_configurations.ChromeBrowser;
import core.helpers.browser_configurations.FirefoxBrowser;
import core.helpers.browser_configurations.IExplorerBrowser;
import core.helpers.browser_configurations.config.ObjectReader;
import core.helpers.browser_configurations.config.PropertyReader;
import core.helpers.logger.MyLogger;
import core.helpers.resource.ResourceHelper;
import core.helpers.wait.WaitHelper;
import core.utlls.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestBase  // TestNg annotation reporting.html
{
    public static ExtentReports extentReports;
    public static ExtentTest test;
    private Logger log = MyLogger.getLogger(TestBase.class);
    private WebDriver driver;
    public static File reportDirectory;


    @BeforeTest
    public void beforeTest()
    {
        ObjectReader.reader = new PropertyReader();
        reportDirectory = new File(ResourceHelper.getRecoursePath("\\src\\main\\java\\core\\screenshots"));
    }

    @BeforeSuite
    public void beforeSuite()
    {
        extentReports = ExtentManager.getInstance();
    }

    @BeforeClass
    public void beforeClass()
    {
        test = extentReports.createTest(getClass().getName());
    }

    @BeforeMethod
    public void beforeMethod(Method method)
    {
        test.log(Status.INFO, method.getName() + " test started");
    }
    //===============================================================================//
    @AfterMethod
    public void afterMethod(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, result.getTestName() + " is pass");
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            test.log(Status.SKIP, result.getThrowable());
        }
        extentReports.flush();
    }
    //===============================================================================//
    public WebDriver getBroserObject(BrowserType btype) throws Exception
    {
        try
        {
            switch (btype)
            {
                case Chrome:
                    //Get object of ChromeBrowser class
                    ChromeBrowser  chrome = ChromeBrowser.class.newInstance(); //Instance of chrome browser
                    ChromeOptions options_0 = chrome.getChromeOptions();
                    return chrome.getChromeDriver(options_0);

                case Firefox:
                    //Get object of Firefox class
                    FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
                    FirefoxOptions options_1 = firefox.getFirefoxOptions();
                    return  firefox.getFirefoxDriver(options_1);

                case IExplorer:
                    IExplorerBrowser ie = IExplorerBrowser.class.newInstance();
                    InternetExplorerOptions cap = ie.getIExplorerCapabilities();
                    return ie.getIternetExplorerDriver(cap);
                default:
                        throw new Exception("Driver not found: " + btype.name());

            }
        }
        catch (Exception e)
        {
            log.info(e.getMessage());
            throw e;
        }
    }
    //===============================================================================//
    public void setUpDriver(BrowserType btype) throws Exception
    {
        driver = getBroserObject(btype);
        log.info("Initialize Web driver: " + driver.hashCode());
        WaitHelper wait = new WaitHelper(driver);
        wait.setImpicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
        wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    //===============================================================================//
    public  String captureScreenShote(String fileName)
    {
        if(driver == null)
        {
            log.info("Driver is null...");
            return null;
        }
        if (fileName == "")
        {
            fileName = "blank";
        }
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File screnshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            destFile = new File(reportDirectory + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
            FileUtils.copyFile(screnshotFile, destFile);
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "'height='100' width='100'/></a>");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return destFile.toString();

    }
    //===============================================================================//
}
