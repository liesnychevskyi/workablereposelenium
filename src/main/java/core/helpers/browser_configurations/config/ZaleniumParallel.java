package core.helpers.browser_configurations.config;

import core.helpers.logger.MyLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class ZaleniumParallel
{
    // Before starting maven xml test, run the zalenium hub docker
    // docker run --rm -ti --name zalenium -p 4444:4444 \-v /var/run/docker.sock:/var/run/docker.sock \ -v tmp/videos:/home/seluser/videos  --privileged dosel/zalenium start
    // https://opensource.zalando.com/zalenium/ - instruction site
    // http://localhost:4444/grid/admin/live - live browser parallel
    // http://localhost:4444/dashboard/      - dashboard for result
    //=============================================================//
//    private Logger log = MyLogger.getLogger(ZaleniumParallel.class);
//    RemoteWebDriver driver;
//    DesiredCapabilities cap;
//
//    @BeforeTest
//    @Parameters("browser")
//    public void setUp(String br) throws MalformedURLException
//    {
//        cap = new DesiredCapabilities();
//
//        if(br.equals("chrome"))
//        {
//            log.info("Chrome driver is started");
//            cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
//            //cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
//            cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
//            //cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//        }
//        else if(br.equals("firefox"))
//        {
//            log.info("Firefox driver is started");
//            cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
//            cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
//            //cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
//            //cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//        }
//            URL url = new URL("http://localhost:4444/wd/hub");
//            driver = new RemoteWebDriver(url,cap);
//    }
//    //==================================================================================//
//
//    @Test
//    public void loginTest() throws InterruptedException
//    {
//        driver.get("https://google.com/");
//        driver.findElement(By.name("q")).click();
//        driver.findElement(By.name("q")).sendKeys("Zalenium automation testing");
//        //driver.findElement(By.xpath("")).click();
//        String res = driver.getTitle();
//        System.out.println(res);
//        Thread.sleep(5000);
//        Assert.assertEquals(driver.getTitle(), "Google");
//    }
//
//    @AfterTest
//    public void shutDown()
//    {
//        driver.quit();
//    }

}
