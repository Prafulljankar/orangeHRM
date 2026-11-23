package TestClasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
	@Test(priority=3,dependsOnMethods= {"testcase2"},enabled=false)  // when testcase 2 execute then testcase3 execute other wise skip, enabled=false are used to skip the method
	public void testcase3() 
	{
		System.out.println("testcase3");
	}
	@Test(priority=1,invocationCount=2) //invocationCount is used to method 2 time execute
	public void testcase1() 
	{
		System.out.println("testcase1");
	}
	
	@Test(priority=2,timeOut=1000)
	public void testcase2() 
	{
		//Assert.fail();//fail testcase fail
		System.out.println("testcase2");
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("Run before @Test method");
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("Run After @Test method");
	}
	
	@BeforeClass
	public void beforeclass() 
	{
		System.out.println("Runs once before class execution");
	}

	@AfterClass
	public void afterclass()
	{
		System.out.println("Runs once after class execution");
	}
}
