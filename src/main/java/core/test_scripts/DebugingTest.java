package core.test_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DebugingTest
{
    WebDriver driver = null;

    @Test
    public void test_1()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://learn-automation.com");
        String title = driver.getTitle();
        System.out.println(title);
        boolean value = title.contains("Selenium");
        System.out.println("Status value is: "  + value);
    }

    @Test
    public void tearDown()
    {
        driver.quit();
    }
}
