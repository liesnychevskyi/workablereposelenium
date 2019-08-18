package test_suite;

import core.test_base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestScreenShot extends TestBase
{
    @Test
    public void testScreen()
    {
        driver.get("https://www.lifehack.org/money");
        captureScreenShot("Money");
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    //====================================================================//

    //====================================================================//
}
