package core.page_objects;

import com.aventstack.extentreports.Status;
import core.helpers.browser_configurations.config.ObjectReader;
import core.helpers.database.DatabaseHelper;
import core.helpers.logger.MyLogger;
import core.helpers.wait.WaitHelper;
import core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeLoginPage
{
    private static Logger log = MyLogger.getLogger(PracticeLoginPage.class);
    private WebDriver driver;
    WaitHelper waitHelper;
//==============================================================================//
    @FindBy(xpath = "")
    WebElement someElement;

    @FindBy(xpath = "")
    WebElement someElement1;

    @FindBy(xpath = "")
    WebElement someElement2;

    @FindBy(xpath = "")
    WebElement someElement3;

    @FindBy(xpath = "")
    List <WebElement> someElements;
//==============================================================================//

    public PracticeLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(someElement,ObjectReader.reader.getExpliciteWait());//this line means what locator we are waiting for.
    }
//===============================================================================//
    public void logExtentReport(String s1)
    {
        TestBase.test.log(Status.INFO, s1);
    }

}
