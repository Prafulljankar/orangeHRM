package TestClasses;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import baseclasses.BaseClassExtent;
import pomClasses.LoginPage;

@Listeners(listeners.ExtentTestListener.class)
public class TestClassExtent1 extends BaseClassExtent 
{

    @Test(priority = 1)
    public void loginTestPass() 
    {
        System.out.println("Running loginTestPass...");

        // Login with valid credentials
        LoginPage login = new LoginPage(driver);
        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();

        // Validate successful login
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login: " + currentUrl);

        Assert.assertTrue(currentUrl.contains("dashboard"), "Login not successful!");
    }

    @Test(priority = 2)
    public void loginTestFail() 
    {
        System.out.println("Running loginTestFail...");

        // Login with invalid credentials (to force failure)
        LoginPage login = new LoginPage(driver);
        login.enterUsername("Admin");
        login.enterPassword("wrongPass");
        login.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after failed login: " + currentUrl);

        // This will fail and trigger screenshot capture via Listener
        Assert.assertTrue(currentUrl.contains("dashboard"), "Forcing a failure to test listener screenshot capture.");
    }

    @Test(priority = 3)
    public void loginTestSkip()
    {
        System.out.println("Running loginTestSkip...");
        throw new SkipException("Skipping this test intentionally to verify skip handling in listener.");
    }
}
