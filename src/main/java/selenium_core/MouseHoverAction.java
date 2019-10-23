package selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class MouseHoverAction
{
    WebDriver driver = null;

    //======================================================================// 1 way
    @Test
    public void mouseHover() throws InterruptedException
    {
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.get("http://www.seleniumframework.com/Practiceform/");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement tutorials = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/li[2]/a/span"));
        WebElement java = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/li[2]/ul/li[3]/a"));

        Thread.sleep(5000);
        action.moveToElement(tutorials).perform();
        Thread.sleep(5000);
        action.moveToElement(java).perform();
        Thread.sleep(5000);
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='sub-nav']//a"));
        int total_count = links.size();
        for(int i = 0; i < total_count; i++)
        {
            WebElement element = links.get(i);

            String linkName = element.getAttribute("innerHTML");

            boolean status = element.isEnabled();

            System.out.println("Link name is: " + linkName + " link status: " + status);

            if(linkName.equalsIgnoreCase("<span>Selenium &amp; Cucumber Frameworks</span>"))
            {
                action.moveToElement(element).click().perform();
                break;
            }
        }

        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
    //======================================================================// 2 way

}
