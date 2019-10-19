package selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ScrollingIntoTheView
{
//    WebDriver driver = null;
//
//    //======================================================================// 1 way
//    @Test
//    public void scrollDown() throws InterruptedException
//    {
//        driver = new ChromeDriver();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Thread.sleep(3000);
//        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/scrollbar_themes_demo.html");
//        Thread.sleep(3000);
//        driver.manage().window().maximize();
//
//        //div[@id='mCSB_11_container']//p[contains(text(),'End of content.')]
//        Thread.sleep(5000);
//        js.executeScript("window.scrollBy(0,1500)");
//        Thread.sleep(5000);
//        js.executeScript("window.scrollBy(0,-1500)");
//        Thread.sleep(10000);
//    }

//    @AfterTest
//    public void tearDown()
//    {
//        driver.quit();
//    }
    //======================================================================// 2 way
    public static void main(String[] args) throws InterruptedException
    {

// Start browser
        WebDriver driver = new ChromeDriver();
// Maximize browser
        driver.manage().window().maximize();
// Pass application URL
        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
// Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
//Identify the WebElement which will appear after scrolling down
        WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
// now execute query which actually will scroll until that element is not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);",element);
// Extract the text and verify
        System.out.println(element.getText());
// Driver quit
        Thread.sleep(10000);
 //       driver.quit();
    }
}
