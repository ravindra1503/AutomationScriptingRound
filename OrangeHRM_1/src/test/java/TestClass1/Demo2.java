package TestClass1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2 {
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("Before Suit Demo2 class");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test Demo2 class");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class Demo2 class");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method Demo2 class");
	}
	@Test
	public void test()
	{
		System.out.println("Test 1 Demo2 class");
	}
	

	@Test
	public void test2()
	{
		System.out.println("Test 2 Demo2 class");
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method Demo2 class");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class Demo2 class");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test Demo2 class");
	}
	@AfterSuite
	public void afterSuit()
	{
		System.out.println("After Suit Demo2 class");
	}


}
