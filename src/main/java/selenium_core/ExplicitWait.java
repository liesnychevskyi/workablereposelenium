package selenium_core;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait
{
    @Test
    public void waitTest() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,300)");
        //----------------------------------------------------------------------------------//

        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement close_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Close')]")));
        //WebElement close_button = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
        boolean status = close_button.isDisplayed();

        if(status)
        {
            System.out.println("Element is visible");
            close_button.click();
            System.out.println("Clicked...");
        }
        else
        {
            System.out.println("Element is not visible ... !!! <<ERROR>>");
        }

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
}
