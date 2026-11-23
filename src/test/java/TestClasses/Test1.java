package TestClasses;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void demo() 
	{
		System.out.println("Welcome toTestNg");
		Reporter.log("Welcome to TestNG",true);
	}
	@Test
	public void e() 
	{
		System.out.println("New Method");
	}

}
