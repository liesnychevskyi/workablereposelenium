package core.helper.browser_configurations;

import core.helper.recourse.RecourseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxBrowser
{
    public FirefoxOptions getFirefoxOptions()
    {
        DesiredCapabilities firefox = DesiredCapabilities.firefox();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        firefox.setCapability(FirefoxDriver.PROFILE, profile);
        firefox.setCapability("marionette", true);

        FirefoxOptions firefoxOptions  = new FirefoxOptions(firefox);
        //Linux
        if(System.getProperty("os.name").contains("Linux"))
        {
            firefoxOptions.addArguments("--headless", "windows-size=1024,768", "--no-sandbox");
        }
        return firefoxOptions;
    }
    //============================================================//
    public WebDriver getFirefoxDriver(FirefoxOptions cap)
    {
        if(System.getProperty("os.name").contains("Mac"))
        {
            System.setProperty("webdriver.chrome.driver", RecourseHelper.getRecoursePath("\\src\\main\\java\\core\\drivers\\geckodriver"));
            return new FirefoxDriver(cap);
        }
        else if(System.getProperty("os.name").contains("Windows"))
        {
            System.setProperty("webdriver.chrome.driver", RecourseHelper.getRecoursePath("\\src\\main\\java\\core\\drivers\\geckodriver.exe"));
            return new FirefoxDriver(cap);
        }
        else if(System.getProperty("os.name").contains("Linux"))
        {
            System.setProperty("webdriver.chrome.driver", "/usr/bin/geckodriver");
            return new FirefoxDriver(cap);
        }
        return null;
    }
    //============================================================//
    //============================================================//
    //============================================================//
    //============================================================//
}
