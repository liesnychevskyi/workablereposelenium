package core.test_scripts;

import core.helpers.assertion.AssertionHelper;
import core.helpers.browser_configurations.config.ObjectReader;
import core.helpers.logger.MyLogger;
import core.page_objects.PracticeLoginPage;
import core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class PracticeLoginTest extends TestBase
{
    private final Logger log = MyLogger.getLogger(PracticeLoginPage.class);

    @Test(description = "Login test with valid credentials")
    public void testLoginToApplication()
    {

       getApplicationUrl (ObjectReader.reader.getApplicationUrl());
       // PracticeLoginPage loginPage = new PracticeLoginPage(driver);
       // come methods from the page class
       // boolean status =  loginPage.verifySuccessLoginMassage();
       // AssertionHelper.updateTestStatus(status);



    }

}
