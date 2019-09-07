package regression_suite;

import core.helpers.assertion.AssertionHelper;
import core.helpers.logger.MyLogger;
import core.helpers.resource.ResourceHelper;
import core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;

public class regression_test_4 extends TestBase
{
    private Logger log = MyLogger.getLogger(regression_test_4.class);
    public static File reportDirectory = new File(ResourceHelper.getRecoursePath("\\src\\main\\java\\core\\screenshots"));

    @Test
    public void goToGoogle() throws InterruptedException
    {
        driver.get("https://www.forbes.com/billionaires/");
        Thread.sleep(5000);
        driver.getTitle();
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToFacebook() throws InterruptedException
    {
        driver.get("https://www.instagram.com/");
        Thread.sleep(5000);
        driver.getTitle();
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToYahoo() throws InterruptedException
    {
        driver.get("http://vexmovies.org/");
        Thread.sleep(5000);
        driver.getTitle();
        AssertionHelper.makeTrue();
    }

    @Test
    public void goToYouTube() throws InterruptedException
    {
        driver.get("https://www.quora.com/What-are-the-must-have-skills-for-automation-testers");
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
