package selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ScrollingDown
{
    WebDriver driver = null;

    //======================================================================// 1 way
    @Test
    public void scrollDown() throws InterruptedException
    {
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();
        // This  will scroll down the page by  1000 pixel vertical
        // executeScript("window.scrollBy(x-pixels,y-pixels)");
        js.executeScript("window.scrollBy(0,1500)");
    }

   //@AfterTest
    public void tearDown()
    {
        driver.quit();
    }
    //======================================================================// 2 way
}
