package core.test_scripts;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerRemoteTest
{
    @Test
    public void dockerRunTestChrome() throws MalformedURLException
    {
        //======================================================//Settings
        DesiredCapabilities cap = DesiredCapabilities.chrome(); // it tels which browser will be run remotely
        URL url = new URL("http://localhost:4444/wd/hub"); // address where Docker  Container is running
        RemoteWebDriver driver = new RemoteWebDriver(url, cap); //Remote WebDriver

        //=====================================================//Test
        driver.get("http://opensource-demo.orangehrmlive.com/");
        String title = driver.getTitle();
        System.out.printf("Title of the page is: " + title);
        driver.quit();
    }

    @Test
    public void dockerRunTestFirefox() throws MalformedURLException
    {
        //======================================================//Settings
        DesiredCapabilities cap = DesiredCapabilities.firefox(); // it tels which browser will be run remotely
        URL url = new URL("http://localhost:4444/wd/hub"); // address where Docker  Container is running
        RemoteWebDriver driver = new RemoteWebDriver(url, cap); //Remote WebDriver

        //=====================================================//Test
        driver.get("http://opensource-demo.orangehrmlive.com/");
        String title = driver.getTitle();
        System.out.printf("Title of the page is: " + title);
        driver.quit();

    }
}
