package core.helper.browser_configurations;

import core.helper.recourse.RecourseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IExplorerBrowser
{
    public InternetExplorerOptions getIExplorerCapabilities()
    {
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
        cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        cap.setJavascriptEnabled(true);
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(cap);
        return internetExplorerOptions;
    }
    //=================================================================================//
    public WebDriver getIternetExplorerDriver(InternetExplorerOptions cap)
    {
         System.setProperty("webdriver.chrome.driver", RecourseHelper.getRecoursePath("\\src\\main\\java\\core\\drivers\\IEDriverServer"));
         return new InternetExplorerDriver(cap);
    }
}

