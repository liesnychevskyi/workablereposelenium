package core.test_scripts;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridChromeTest_2
{
    @Test
    public void test_2() throws MalformedURLException
    {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        //----------------------------------------------------//
        driver.get("http://www.google.com/");
        String title = driver.getTitle();
        System.out.printf("Title of the page is: " + title);
        driver.quit();
    }
}
