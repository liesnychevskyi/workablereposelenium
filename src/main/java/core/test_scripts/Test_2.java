package core.test_scripts;

import core.helpers.assertion.AssertionHelper;
import core.test_base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_2 extends TestBase
{

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
}
