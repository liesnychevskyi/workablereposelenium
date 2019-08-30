package core.page_objects;

import core.helpers.assertion.VerificationHelper;
import core.helpers.browser_configurations.config.ObjectReader;
import core.helpers.logger.MyLogger;
import core.helpers.wait.WaitHelper;
import core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;
    WaitHelper waitHelper;
    private final Logger log = MyLogger.getLogger(LoginPage.class);

    @FindBy(xpath = "//*[@id='center_column']/h1")
    WebElement authenticate;

    @FindBy(xpath = "//*[@id='create_account_form']/div/p")
    WebElement createAnAccountMassage;

    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement signIn;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='SubmitLogin'")
    WebElement submitLogin;

    @FindBy(xpath = "//*[@id='SubmitCreate'")
    WebElement createAnAccount;

    @FindBy(xpath = "//*[@id='center_column']/p")
    WebElement successMsgObject;

    @FindBy(xpath = "//*[@id='email_create'")
    WebElement registrationMailAddress;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(signIn, ObjectReader.reader.getExpliciteWait());
        new TestBase().captureScreenShot("today", driver);
        TestBase.logExtentReport("Login Page Object Created");
    }

    public void clickOnSignLink()
    {
        log.info("Clicking on sign in link");
        signIn.click();
    }

    public void enterRegistrationEmail()
    {
        String email = System.currentTimeMillis()+"@gmail.com";
        log.info("Entering mail ... " + email);
        registrationMailAddress.sendKeys(email);
    }

    public void clickOnCreateAccount()
    {
        log.info("");

    }

    public boolean verifySuccessLoginMsg()
    {
        return new VerificationHelper(driver).isDisplayed(successMsgObject);
    }
}
