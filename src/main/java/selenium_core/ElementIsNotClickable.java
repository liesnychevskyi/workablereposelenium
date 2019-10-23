package selenium_core;

import core.helpers.click.Click;
import core.helpers.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ElementIsNotClickable
{
    WebDriver driver = null;

    //======================================================================// 1 way
    @Test
    public void NOTCLICKABLEELEMENT() throws InterruptedException
    {
        System.setProperty("webdriver.gecko.driver", ResourceHelper.getRecoursePath("/src/main/java/core/drivers/geckodriver"));
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://login.yahoo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //WebElement ele = driver.findElement(By.id("persistent"));
        //WebElement ele = driver.findElement(By.xpath("//label[@for='persistent']"));
        //actions.moveToElement(driver.findElement(By.id("persistent"))).click().build().perform();
        //Click.clickById(driver, "persistent");
        Click.clickByXpath(driver, "//label[@for='persistent']");
        Thread.sleep(5000);

    }

    //@AfterTest
    public void tearDown()
    {
        driver.quit();
    }
    //======================================================================// 2 way
}
