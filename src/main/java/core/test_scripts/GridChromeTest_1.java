package core.test_scripts;

import core.helpers.docker.SetUp_DockerGrid_macos;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GridChromeTest_1
{
    @Test
        public void test_1() throws IOException, InterruptedException
        {
            SetUp_DockerGrid_macos setup = new SetUp_DockerGrid_macos();
            setup.startDockerGrid();
            Thread.sleep(5000);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            URL url = new URL("http://localhost:4444/wd/hub");
            RemoteWebDriver driver = new RemoteWebDriver(url, cap);
            //----------------------------------------------------//
            driver.get("http://opensource-demo.orangehrmlive.com/");
            String title = driver.getTitle();
            System.out.printf("Title of the page is: " + title);
            driver.quit();

            setup.stopDockerGrid();
    }
}
