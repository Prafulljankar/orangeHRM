package baseclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    protected WebDriver driver;

    public void setUp(String url) //setup browser open
    {

       WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
    }
    public void tearDown() //tear down browser close
    {

        if (driver != null) {
            driver.quit();
        }
    }
}
