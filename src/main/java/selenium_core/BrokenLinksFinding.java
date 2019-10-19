package selenium_core;

import core.helpers.resource.ResourceHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksFinding
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.gecko.driver", ResourceHelper.getRecoursePath("/src/main/java/core/drivers/geckodriver"));
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.co.in/");
        List<WebElement> links=driver.findElements(By.tagName("a")); // Find all the links on the page and store
        System.out.println("Total links are " + links.size());

        for(int i=0;i<links.size();i++) // Print all the links
        {
            WebElement ele = links.get(i);
            String url = ele.getAttribute("href");// Take each tag that contains href
            verifyLinkActive(url);
        }
    }

    public static void verifyLinkActive(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(3000); // wait 3 sec. for response
            httpURLConnect.connect(); //connect

            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }

            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }

        }
        catch
        (Exception e)
        {

        }
    }
}
