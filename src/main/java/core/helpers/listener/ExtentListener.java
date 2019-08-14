package core.helpers.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import core.utlls.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ExtentListener implements ITestListener
{
    public static ExtentReports extentReports;
    public static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result)
    {
        test.log(Status.INFO, result.getName() + " started...");
        Reporter.log(result.getMethod().getMethodName() + " Test Started ");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.log(Status.INFO, result.getName() + " passed...");
        Reporter.log(result.getMethod().getMethodName() + " Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        test.log(Status.FAIL, result.getThrowable());
        Reporter.log(result.getMethod().getMethodName() + " Test Failed..." + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        test.log(Status.SKIP, result.getThrowable());
        Reporter.log(result.getMethod().getMethodName() + " Test Skipped..." + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }
//-------------------------------------------------------------------------//
    @Override
    public void onStart(ITestContext context)
    {
        extentReports = ExtentManager.getInstance();
        //test = extentReports.createTest(context.getName());
        test = extentReports.createTest(context.getCurrentXmlTest().getName());
        Reporter.log(context.getName() + " Test Started...");
    }

    @Override
    public void onFinish(ITestContext context)
    {
        extentReports.flush();
    }
}
