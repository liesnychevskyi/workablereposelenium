package core.test_scripts;

import core.helpers.assertion.AssertionHelper;
import core.test_base.TestBase;
import java_core.practice.TestClass;
import org.testng.annotations.Test;

public class ExtentReportTest extends TestBase
{
    @Test
    public void testReport_0()
    {
        AssertionHelper.makeTrue();
    }

    @Test
    public void testReport_1()
    {
        AssertionHelper.makeFalse();
    }

    @Test
    public void testReport_2()
    {
        AssertionHelper.makeTrue();
    }

    @Test
    public void testReport_3()
    {
        AssertionHelper.makeFalse();
    }
}
