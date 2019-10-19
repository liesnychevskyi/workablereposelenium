package selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownList
{

    //getFirstSelectedOption() - it takes value from the element

    //======================================================================// 1 way
//    @Test
//    public void selectDropDownValues() throws InterruptedException
//    {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://facebook.com/");
//        driver.manage().window().maximize();
//        WebElement monthDropDown = driver.findElement(By.id("month"));
//
//        Select month_drop_down = new Select(monthDropDown); //Select class will focus on the drop down.
//        Thread.sleep(3000);
//        //select march month
//        month_drop_down.selectByIndex(3); // it will take value from 0 to end, and act with this.
//        Thread.sleep(3000);
//        //select october month
//        month_drop_down.selectByValue("10");// it will take value of element and act with this.
//        Thread.sleep(3000);
//        //select august
//        month_drop_down.selectByVisibleText("Aug");// most recommended way
//        Thread.sleep(3000);
//    }
    //======================================================================// 2 way
//    @Test
//    public void selectDropDownValues() throws InterruptedException
//    {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://facebook.com/");
//        driver.manage().window().maximize();
//        WebElement monthDropDown = driver.findElement(By.id("month"));
//
//        Select month_drop_down = new Select(monthDropDown); //Select class will focus on the drop down.
//        Thread.sleep(3000);
//
//        //check the default value should return "current month"
//        WebElement selected_value_before = month_drop_down.getFirstSelectedOption();
//        System.out.println("Befor Selection, selected value is: " + selected_value_before.getText());
//
//        //select march month
//        month_drop_down.selectByIndex(3); // it will take value from 0 to end, and act with this.
//
//        //we need to check the selected value should return "March"
//        WebElement selected_value_after = month_drop_down.getFirstSelectedOption();
//        System.out.println("After Selection, selected value is: " + selected_value_after.getText());
//    }
    //======================================================================// 3 way
    @Test
    public void selectDropDownValues() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        driver.manage().window().maximize();
        WebElement monthDropDown = driver.findElement(By.id("month"));

        Select month_drop_down = new Select(monthDropDown); //Select class will focus on the drop down.
        Thread.sleep(3000);

        List<WebElement> month_list =  month_drop_down.getOptions(); // method returns list of elements.
        int total_month = month_list.size();
        Assert.assertEquals(total_month, 13);
        System.out.println("Total month count is: " + total_month);
        for(WebElement element : month_list)
        {
            System.out.println("Month is: " + element.getText());
        }
        // Expected list we should to create for comparing

        List<WebElement> selected_elements = month_drop_down.getAllSelectedOptions(); // method returns list of almost selected elements.




    }
}
