package selenium_core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions
{
    @Test
    public void assertionTest_1() throws InterruptedException
    {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://facebook.com/");
//        driver.manage().window().maximize();
//        Assert.assertEquals(boolean actual, boolean expected);
    }

    @Test
    public void assertionTest_2() throws InterruptedException
    {
       Assert.assertEquals(20,20);
    }

    @Test
    public void assertionTest_3() throws InterruptedException
    {
        System.out.println("Test case 3 started");
        Assert.assertEquals(23,20,"Error something wrong ...");
        System.out.println("Test case 3 completed");
    }

    @Test
    public void assertionTest_4() throws InterruptedException
    {
        System.out.println("Test case 4 started");
        Assert.assertEquals("Hello","Hello","Error something wrong ...");
        System.out.println("Test case 4 completed ");
    }

    @Test
    public void assertionTest_5() throws InterruptedException
    {
        System.out.println("Test case 5 started");
        String myString = "Stan";
        Assert.assertTrue(myString.contains("Stanislav"),"Name is not matching");
        System.out.println("Test case 5 completed ");
    }

    @Test
    public void assertionTest_6() throws InterruptedException
    {
        System.out.println("Test case 6 started");
        Assert.assertTrue(false);
        System.out.println("Test case 6 completed ");
    }
}
