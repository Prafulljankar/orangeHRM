
package TestClasses;

import org.testng.annotations.Test;

import baseclasses.baseclass1;
import pomClasses.LoginPage;

public class OrangeTest extends baseclass1 {

    @Test
    public void loginTest() {

        LoginPage login = new LoginPage(driver);

        login.enterUsername("Admin");

        login.enterPassword("admin123");

        login.clickLogin();
    }
}
