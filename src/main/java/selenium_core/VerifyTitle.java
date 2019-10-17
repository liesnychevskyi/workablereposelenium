package selenium_core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitle
{
    @Test
    public void assertionTest_1() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        String expected_title = "Facebook - Log In or Sign Up";
        Assert.assertEquals(title, expected_title);
        System.out.println("Test completed");
    }

    @Test
    public void assertionTest_2() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        String expected_title = "Facebook - Log In or Sign Up";
        //Assert.assertEquals(title, expected_title);
        Assert.assertTrue(title.contains("Facebook"));
        System.out.println("Test completed page verified");
    }

    @Test
    public void assertionTestGetPageSource_3() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        driver.manage().window().maximize();
        String title = driver.getPageSource();
        System.out.println("Title is: " + title);
        String expected_title = "Facebook - Log In or Sign Up";
        //Assert.assertEquals(title, expected_title);
        Assert.assertTrue(title.contains("Facebook"));
        System.out.println("Test completed page verified");
    }
}
