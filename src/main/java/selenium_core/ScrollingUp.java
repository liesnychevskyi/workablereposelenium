package selenium_core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ScrollingUp
{
    WebDriver driver = null;

    //======================================================================// 1 way
    @Test
    public void scrollDown() throws InterruptedException
    {
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        driver.get("https://omayo.blogspot.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        // This  will scroll down the page by  1000 pixel vertical
        // executeScript("window.scrollBy(x-pixels,y-pixels)");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,-1500)");
        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
    //======================================================================// 2 way
}
