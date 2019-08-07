package core.test_scripts;

import core.helpers.browser_configurations.ChromeBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest
{
    private WebDriver driver;


    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void goToGoogle()
    {
        driver.get("http://google.com");
        Assert.assertTrue(true);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
