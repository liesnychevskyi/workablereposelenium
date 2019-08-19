package core.page_objects;

import core.helpers.browser_configurations.config.ObjectReader;
import core.helpers.logger.MyLogger;
import core.helpers.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage
{
    private static Logger log = MyLogger.getLogger(SignUpPage.class);
    private WebDriver driver;
    WaitHelper waitHelper;
    //==============================================================================//
    @FindBy(xpath = "//a[@crxanalyticsevent='Header - Sign Up or Log In Clicked']")
    WebElement SignUpOrLogin;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement FirstName;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement LastName;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement Email;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement Password;

    @FindBy(xpath = "//ng-select[@formcontrolname='role']")
    WebElement indRole;

    @FindBy(xpath = "//div[@class='scrollable-content']/div")
    List<WebElement> IndustryRole;
//=============================================================//
    @FindBy(xpath = "//div[@id='a7daeee2f8ff']")
    WebElement Broker;

    @FindBy(xpath = "//div[@id='ae635ef9a4a1-0']")
    WebElement ListingBroker;

    @FindBy(xpath = "//div[@id='a157687b30bd-1']")
    WebElement BuyerBroker;

    @FindBy(xpath = "//div[@id='abc7bda55ac6-2']")
    WebElement SellingBuyingBroker;

    @FindBy(xpath = "//div[@id='abc7bda55ac6-3']")
    WebElement TransactionCoordinator;

    @FindBy(xpath = "//div[@id='abc7bda55ac6-4']")
    WebElement Principal;

    @FindBy(xpath = "//div[@id='abc7bda55ac6-5']")
    WebElement Lender;

    @FindBy(xpath = "//div[@id='abc7bda55ac6-6']")
    WebElement ThirdPartyService;
//=============================================================//

    @FindBy(xpath = "//input[@formcontrolname='phone']")
    WebElement PhoneNumber;

    @FindBy(xpath = "//button[@type='submit' and text()='Sign Up']")
    WebElement SignUp;

    @FindBy(xpath = "//h1[ text()='Sign Up']")
    WebElement SignUpTitle;

//==============================================================================//

    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SignUpOrLogin, ObjectReader.reader.getExpliciteWait());//this line means what locator we are waiting for.
    }
    //===============================================================================//
    public void clickSignOrLoginButton()
    {
//        WaitHelper wait  = new WaitHelper(driver);
//        wait.WaitForElementClickable(SignUpOrLogin, 5);
        SignUpOrLogin.click();
    }

    public void fillFirstNAme(String name)
    {
        FirstName.sendKeys(name);
    }

    public void fillLastNAme(String lastname)
    {
        LastName.sendKeys(lastname);
    }

    public void fillEmail()
    {
        String email = System.currentTimeMillis()+"@gmail.com";
        Email.sendKeys(email);
    }

    public void fillPassword(String password)
    {
        Password.sendKeys(password);
    }

    public void clickIndustryRole()
    {
        indRole.click();
    }

    public  void clickFromTheList(String role) throws Exception
    {
        for(WebElement element: IndustryRole)
        {
            if(element.getText().equalsIgnoreCase(role))
            {
                System.out.println(element.getText());
                element.click();
                Thread.sleep(3000);
            }
            else
            {
                System.out.println(element.getText());
                //System.out.println("The element out of the list");
            }
        }
    }


    public void fillPhoneNumber(String phone) throws Exception
    {
        Thread.sleep(3000);
        PhoneNumber.sendKeys(phone);
    }

    public void clickSignUpButton()
    {
        SignUp.click();
    }

//    public static boolean verifySuccessLoginMassage()
//    {
//
//    }

}
