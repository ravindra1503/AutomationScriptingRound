package TestClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Browser;
import POM.Arrivals;
import POM.Home;
import POM.MasteringJavaScript;
import POM.SeleniumRuby;
import POM.Shop;
import POM.Sliders;
import POM.ThinkingInHTML;
import utils.Utility;

public class TestClassWithTestNG extends Browser
{
	private WebDriver driver;
	private SoftAssert softAssert;
	private Shop shop;
	private Home home;
	private Sliders sliders;
	private Arrivals arrivals;
	private SeleniumRuby seleniumRuby;
	private ThinkingInHTML thinkingInHTML;
	private MasteringJavaScript masteringJavaScript;
	private int TestId;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = lanuchChormeBrowser();
			
		}
		if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = lanuchFirefoxBrowser();
			
		}
			
	}
	
	
	@BeforeClass
	public void objectOfPOM()
	{
		shop=new Shop(driver);
		home=new Home(driver);
		sliders= new Sliders(driver);
		arrivals=new Arrivals(driver);
		seleniumRuby=new SeleniumRuby(driver);
		thinkingInHTML=new ThinkingInHTML(driver);
		masteringJavaScript= new MasteringJavaScript(driver);
		
	}
	
	
	
	@BeforeMethod
	public void beforeMethod()
	{
				
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		shop.clickOnShop();
		
		home.clickOnHome();
		
	}
	
	@Test
	public void verifySliders()
	{
		TestId=101;
		softAssert=new SoftAssert();
		
		int slidersSize=sliders.sliderSize();
		softAssert.assertEquals(slidersSize, 3);
		
//		if(slidersSize == 3)
//			System.out.println("Test Case is passed.");
//		else 
//			System.out.println("Test case is failed!");
		
		softAssert.assertAll();
	}
	
	@Test
	public void verifyArrivals()
	{
		TestId=102;
		softAssert=new SoftAssert();
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		
//		if(arrivalssize == 3)
//			System.out.println("Test Case is passed.");
//		else 
//			System.out.println("Test case is failed!");
		
		softAssert.assertAll();
	}
	
	@Test
	public void seleniumRuby()
	{
		TestId=103;
		softAssert=new SoftAssert();
		
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		
		
		seleniumRuby.clickOnSeleniumRubyImage();
		driver.navigate().back();
		
		
		thinkingInHTML.clickOnThinkingInHTMLImage();
		driver.navigate().back();
		
		
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		driver.navigate().back();
		softAssert.assertAll();
		
	}
	
	
	@Test
	public void imagesDiscription()
	{
		TestId=104;
		softAssert=new SoftAssert();
		
		int arrivalssize=arrivals.arrivalSize();
		softAssert.assertEquals(arrivalssize, 3);
		
		
		seleniumRuby.clickOnSeleniumRubyImage();
		String DescriptionSeleneiumRubyPage =seleniumRuby.verifySeleniumRubyDescription();
		if(DescriptionSeleneiumRubyPage.contains("Selenium WebDriver Recipes book is a quick problem-solving guide"))
			{
				System.out.println("Test Case is passed for description available for 1st image");
			}
		else
			{
				System.out.println("Test case is failed!");
			}
		
		
		driver.navigate().back();
		
		
		thinkingInHTML.clickOnThinkingInHTMLImage();
		thinkingInHTML.clickOnThinkingInHTMLImage();
		String DescriptionThinkingInHTMLPage=thinkingInHTML.verifyThinkingInHTMLDescription();
			if(DescriptionThinkingInHTMLPage.contains("This book provides you with an intermediate knowledge of HTML"))
				{
					System.out.println("Test Case is passed for description available for 2nd image");
				}
			else
				{
					System.out.println("Test case is failed!");
				}
		
		driver.navigate().back();
		
		
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		String DescriptionMasteringJavaScriptPage =masteringJavaScript.verifyMasteringJavaScriptDescription();
			if(DescriptionMasteringJavaScriptPage.contains("it is difficult to find a topic related to JavaScript that has not been discussed"))
				{
					System.out.println("Test Case is passed for description available for 3rd image");
				}
			else
				{
					System.out.println("Test case is failed!");
				}
		driver.navigate().back();
		softAssert.assertAll();
		
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshotOfFailedTC(driver, TestId);
		}
		
		driver.navigate().refresh();
	}
	
	@AfterClass
	public void closePOMObject()
	{
		shop=null;
		home=null;
		sliders= null;
		arrivals=null;
		seleniumRuby=null;
		thinkingInHTML=null;
		masteringJavaScript= null;
	}

	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
	
	
}
