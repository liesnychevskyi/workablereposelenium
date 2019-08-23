package core.test_scripts;

import core.helpers.assertion.AssertionHelper;
import core.helpers.browser_configurations.config.ObjectReader;
import core.helpers.logger.MyLogger;
import core.page_objects.PracticeLoginPage;
import core.page_objects.SignUpPage;
import core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SignUpTest extends TestBase
{
    //-----------------------------------------------------------
    String firstName = "Donald";
    String lastName = "Trump";
    String phone = "0976560488";
    String password = "12345@abc";
    String role = "Lender";

    //-----------------------------------------------------------
    private final Logger log = MyLogger.getLogger(SignUpTest.class);

    @Test(description = "Sign up new account")
    public void testLoginToApplication() throws Exception
    {
        getApplicationUrl (ObjectReader.reader.getApplicationUrl());
        SignUpPage page = new SignUpPage(driver);
        page.clickSignOrLoginButton();
        page.fillFirstNAme(firstName);
        page.fillLastNAme(lastName);
        page.fillEmail();
        page.fillPassword(password);

        page.clickIndustryRole();
        page.clickFromTheList(role);
        page.fillPhoneNumber(phone);
        page.clickSignUpButton();

        // boolean status =  SignUpPage.verifySuccessLoginMassage();
        // AssertionHelper.updateTestStatus(status);
    }
}
