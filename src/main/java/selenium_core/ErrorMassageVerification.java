package selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMassageVerification
{
    // innerHTML means : get some value from tag

    @Test
    public void assertionTestGetPageSource_3() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8000/wp-login.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("stas");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("12345");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        Thread.sleep(3000);
        //String actual_res = driver.findElement(By.xpath("//div[@id='login_error']")).getText();
        String actual_res = driver.findElement(By.xpath("//div[@id='login_error']")).getAttribute("innerHTML");
        System.out.println("Actual result is: =>  " + actual_res);
        String expected_error = "ERROR: The password you entered for the username stas is incorrect. Lost your password?";
        Assert.assertEquals(actual_res, expected_error,"Error Test failed:==>>");

    }
}
