package selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButton_CheckBox
{
    WebDriver driver = null;
    JavascriptExecutor js = null;

    //======================================================================// radio button
    @Test
    public void selectRadioButton() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();
        List<WebElement> radio_list = driver.findElements(By.xpath("//input[@name='gender' and @type='radio']"));
        for(int i = 0; i < radio_list.size(); i++)
        {
            WebElement local_radio = radio_list.get(i);
            String value = local_radio.getAttribute("value");
            System.out.println("Value from radio button: " + value);
            if(value.equalsIgnoreCase("female"))
            {
                local_radio.click();
                break;
            }
            Assert.assertTrue(true);
        }
    }

   // @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
    //======================================================================// checkbox
    @Test
    public void selectCheckBox() throws InterruptedException
    {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,1500)");
        List<WebElement> check_box_list = driver.findElements(By.xpath("//input[@name='accessories' and @type='checkbox']"));
        Thread.sleep(3000);
        for(int i = 0; i < check_box_list.size(); i++)
        {
            WebElement local_radio = check_box_list.get(i);
            String value = local_radio.getAttribute("value");
            System.out.println("Value from checkbox: " + value);
            if(value.equalsIgnoreCase("pen"))
            {
                local_radio.click();
                break;
            }
        }
        Assert.assertTrue(true);

    }
}
