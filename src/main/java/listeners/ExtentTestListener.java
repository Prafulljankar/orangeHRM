package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.Status;
import baseclasses.BaseClassExtent;
import utilityClasses.ExtentManager;
import utilityClasses.ScreenshotUtils;


public class ExtentTestListener extends BaseClassExtent implements ITestListener
{

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result)
    {
        String testName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(testName);
        testThread.set(test);
        test.log(Status.INFO, "Test started: " + testName);
        System.out.println("Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) 
    {
        String testName = result.getMethod().getMethodName();
        testThread.get().log(Status.PASS, "Test passed: " + testName);
        System.out.println("Test passed: " + testName);
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        String testName = result.getMethod().getMethodName();
        Throwable cause = result.getThrowable();

        ExtentTest test = testThread.get();
        if (test == null) {
            test = extent.createTest(testName);
            testThread.set(test);
        }

        test.log(Status.FAIL, "Test failed: " + cause);
        System.out.println("Test failed: " + testName + " | Reason: " + cause);

        try {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, testName);
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
                test.log(Status.INFO, "Screenshot attached: " + screenshotPath);
            } else 
            {
                test.log(Status.WARNING, "Screenshot path is null.");
            }
        } 
        catch (Exception e)
        {
            test.log(Status.WARNING, "Error capturing screenshot: " + e.getMessage());
            System.out.println("Error capturing screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) 
    {
        String testName = result.getMethod().getMethodName();
        String reason = (result.getThrowable() != null)
                ? result.getThrowable().getMessage()
                : "No skip reason provided";

        ExtentTest test = testThread.get();
        if (test == null) 
        {
            test = extent.createTest(testName);
            testThread.set(test);
        }

        test.log(Status.SKIP, "Test skipped: " + testName);
        test.log(Status.INFO, "Reason: " + reason);
        System.out.println("Test skipped: " + testName + " | Reason: " + reason);
    }

    @Override
    public void onStart(ITestContext context)
    {
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) 
    {
        extent.flush();
        System.out.println("Extent Report generated successfully for suite: " + context.getName());
    }
}