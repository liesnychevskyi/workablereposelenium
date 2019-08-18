package test_suite;

import core.test_base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGtesting_3 extends TestBase
{
    int i = 1;
    @Test
    public void testLogin()
    {
        if(i == 3)
        {
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("it is = " + i);
            i++;
            Assert.assertTrue(false);
        }
    }
}
