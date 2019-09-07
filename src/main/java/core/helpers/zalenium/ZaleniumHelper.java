package core.helpers.zalenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ZaleniumHelper
{
    // Befor starting maven xml test, run the zalenium hub docker
    // https://opensource.zalando.com/zalenium/ - instruction site
    //http://localhost:4444/grid/admin/live - live browser parallel
    //http://localhost:4444/dashboard/      - dashboard for result
    RemoteWebDriver driver;
    DesiredCapabilities cap;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String br) throws MalformedURLException
    {
        cap = new DesiredCapabilities();

        if(br.equals("chrome"))
        {
            cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
            //cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
            //cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        }
        else if(br.equals("firefox"))
        {
            cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
            cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
            //cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
            //cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        }

        URL url = new URL("http://localhost:4444/wd/hub");
        driver = new RemoteWebDriver(url,cap);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void loginTest() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.id("Email")).sendKeys("pavanoltraining@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test@12345");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
