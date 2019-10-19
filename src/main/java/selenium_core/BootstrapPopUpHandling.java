package selenium_core;

import core.helpers.resource.ResourceHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BootstrapPopUpHandling
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.gecko.driver", ResourceHelper.getRecoursePath("/src/main/java/core/drivers/geckodriver"));
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");
        driver.findElement(By.xpath("//body/div[@class='container-fluid text-center']/div[@class='row']/div[@class='col-md-6 text-left']/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='myModal0']//a[@class='btn btn-primary'][contains(text(),'Save changes')]")).click();
    }

}
