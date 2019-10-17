package selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BootstrapDropDownHandling
{
    WebDriver driver = null;

    @Test
    public void dropDownTest() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
        driver.manage().window().maximize();
        driver.findElement(By.id("btnDropdownDemo")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> drop_menu = driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));

        for(int i = 0; i < drop_menu.size(); i++)
        {
            WebElement element = drop_menu.get(i);
            //String inner_html = element.getAttribute("innerHTML");
            //System.out.println("Value from dropdown is: " + inner_html);
            String text = element.getText();
            Thread.sleep(2000);

            if(text.contentEquals("jQuery"))
            {
                element.click();
                break;
            }
        }
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }


}
