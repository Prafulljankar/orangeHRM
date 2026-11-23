package baseclasses;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilityClasses.ExtentManager;

public class BaseClassExtent {

    // Protected so child classes can use them
    public static WebDriver driver;
    protected static ExtentReports extent;
     protected static ExtentTest test;

    @BeforeSuite
    public void startReport() {
        // Initialize Extent Report once per suite
    	 extent = ExtentManager.getInstance();
    }

    @BeforeClass
    public void setUp() {
        // Launch Browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open OrangeHRM application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void endReport() {
        // Flush Extent Report at the end of suite execution
        if (extent != null) {
            extent.flush();
        }
    }
}