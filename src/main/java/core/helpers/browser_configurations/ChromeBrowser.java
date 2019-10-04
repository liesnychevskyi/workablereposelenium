package core.helpers.browser_configurations;

import core.helpers.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser
{
    /**
     * This method will give us Chrome options and Capabilities
     * @return
     */
    public ChromeOptions getChromeOptions()
    {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--test-type--");
        option.addArguments("--disable-popup-blocking");

        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        chrome.setJavascriptEnabled(true);
        option.setCapability(ChromeOptions.CAPABILITY, chrome);
    //============================================================//
        //Linux
        if(System.getProperty("os.name").contains("Linux"))
        {
            option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        }
        return option;
    }
    //============================================================//
    public WebDriver getChromeDriver(ChromeOptions cap)
    {
        if(System.getProperty("os.name").contains("Mac"))
        {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getRecoursePath("/src/main/java/core/drivers/chromedriver"));
            return new ChromeDriver(cap);
        }
//=======================================================================================================//
        else if(System.getProperty("os.name").contains("Windows"))
        {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getRecoursePath("\\src\\main\\java\\core\\drivers\\chromedriver.exe"));
           // return new ChromeDriver(cap);
            return new ChromeDriver();
        }
//=======================================================================================================//
        else if(System.getProperty("os.name").contains("Linux"))
        {
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            return new ChromeDriver(cap);
        }
        return null;
    }
//========================================================================================================//
}
