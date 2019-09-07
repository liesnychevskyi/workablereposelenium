package regression_suite;

import core.helpers.assertion.AssertionHelper;
import core.helpers.logger.MyLogger;
import core.helpers.resource.ResourceHelper;
import core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;

public class regression_test_5 extends TestBase
{
    private Logger log = MyLogger.getLogger(regression_test_5.class);
    public static File reportDirectory = new File(ResourceHelper.getRecoursePath("\\src\\main\\java\\core\\screenshots"));

    @Test
    public void goToGoogle() throws InterruptedException
    {
        driver.get("https://www.success.com/");
        Thread.sleep(5000);
        driver.getTitle();
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToFacebook() throws InterruptedException
    {
        driver.get("https://learnenglish.britishcouncil.org/");
        Thread.sleep(5000);
        driver.getTitle();
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToYahoo() throws InterruptedException
    {
        driver.get("https://en.wikipedia.org/wiki/Derhachi");
        Thread.sleep(5000);
        driver.getTitle();
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToYouTube() throws InterruptedException
    {
        driver.get("https://www.cia.gov/library/publications/the-world-factbook/geos/mn.html");
        Thread.sleep(5000);
        driver.getTitle();
        AssertionHelper.makeTrue();
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    //====================================================================//

    //====================================================================//
}
