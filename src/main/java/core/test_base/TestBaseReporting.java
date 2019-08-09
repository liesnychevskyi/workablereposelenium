package core.test_base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import core.helpers.browser_configurations.BrowserType;
import core.helpers.browser_configurations.ChromeBrowser;
import core.helpers.browser_configurations.FirefoxBrowser;
import core.helpers.browser_configurations.IExplorerBrowser;
import core.helpers.logger.MyLogger;
import core.helpers.wait.WaitHelper;
import core.utlls.ExtentManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBaseReporting  // TestNg annotation reporting.html
{
    public static ExtentReports extentReports;
    public static ExtentTest test;
    private Logger log = MyLogger.getLogger(TestBaseReporting.class);
    private WebDriver driver;

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

    public void setUpDriver(BrowserType btype) throws Exception
    {
        driver = getBroserObject(btype);
        log.info("Initialize Web driver: " + driver.hashCode());
        WaitHelper wait = new WaitHelper(driver);
        wait.setImpicitWait(30, TimeUnit.SECONDS);
        wait.pageLoadTime(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

}
