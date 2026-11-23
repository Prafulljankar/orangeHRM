package TestClasses;


import baseclasses.BaseClass;
import pomClasses.LoginPage;

public class LoginTest extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		LoginTest test=new LoginTest();
		test.setUp("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		LoginPage login=new LoginPage(test.driver);
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLogin();
		
		test.tearDown();

	}

}
