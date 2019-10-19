package selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FluentWaitMethod
{
    @Test
    public void waitTest() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();

        //----------------------------------------------------------------------------------//
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.manage().window().maximize();
        //-----------------------------------------------------------------------------------//
        Thread.sleep(8000);
        driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
        //-----------------------------------------------------------------------------------//Waiting for element
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(50, TimeUnit.SECONDS)
//                .pollingEvery(250, TimeUnit.MILLISECONDS)
//                .ignoring(NoSuchElementException.class);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(600))
                .ignoring(NoSuchElementException.class);
        //-----------------------------------------------------------------------------------//WebElement
        WebElement close_button = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver)
            {
                WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
                String value = ele.getAttribute("innerHTML");
                System.out.println("WebElement is:======>> " + value);
                if(ele.isDisplayed() && value.equalsIgnoreCase("Close"))
                {
                    return ele;
                }
                else
                {
                    System.out.println("Text which is coming on screen is: " + value);
                    return null;
                }
            }
        });
            System.out.println("Element is visible");
            close_button.click();
            System.out.println("Clicked...");
/////////////------------------------------------------------------------------------------------//

/////////////------------------------------------------------------------------------------------//
//        WebElement close_button = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
//
//        boolean status = close_button.isDisplayed();
//
//        if(status)
//        {
//            System.out.println("Element is visible");
//            close_button.click();
//            System.out.println("Clicked...");
//        }
//        else
//        {
//            System.out.println("Element is not visible ... !!! <<ERROR>>");
//        }
//////////-----------------------------------------------------------------------------------------//
    }
}
