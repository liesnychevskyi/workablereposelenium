package test_suite;

import core.test_base.TestBase;
import org.testng.annotations.Test;

public class TestScreenShot extends TestBase
{
    @Test
    public void testScreen()
    {
        driver.get("https://www.lifehack.org/money");
        captureScreenShot("Money");
    }
}
