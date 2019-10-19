package selenium_core;

import core.helpers.resource.ResourceHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IframeHandling
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.gecko.driver", ResourceHelper.getRecoursePath("/src/main/java/core/drivers/geckodriver"));
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/iframe");
        Thread.sleep(5000);
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("My name is Stanislav, I am 36 years old and I am very rich person." +
                "I have 3 600 000 $ dollars");
    }
}
