package TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.Arrivals;
import POM.Home;
import POM.MasteringJavaScript;
import POM.SeleniumRuby;
import POM.Shop;
import POM.Sliders;
import POM.ThinkingInHTML;

public class TestClassWithMainMethod {
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation Testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1. Shop link
		Shop shop=new Shop(driver);
		
		
		//2. Home Link
		Home home=new Home(driver);
		
		
		//3. Test Case 1-to verify Sliders
		Sliders sliders= new Sliders(driver);
		shop.clickOnShop();
		home.clickOnHome();
		
		int slidersSize=sliders.sliderSize();
		if(slidersSize == 3)
			System.out.println("Test Case is passed.");
		else 
			System.out.println("Test case is failed!");
		
		
		//4. Test Case 2-to verify Arrivals on shop page page
		Arrivals arrivals=new Arrivals(driver);
		shop.clickOnShop();
		home.clickOnHome();
		
		int arrivalssize=arrivals.arrivalSize();
		
		if(arrivalssize == 3)
			System.out.println("Test Case is passed.");
		else 
			System.out.println("Test case is failed!");
		
		
		//5. Test Case 3-Home page-images in arrivals should navigate
		
		shop.clickOnShop();
		home.clickOnHome();
		
		SeleniumRuby seleniumRuby=new SeleniumRuby(driver);
		ThinkingInHTML thinkingInHTML=new ThinkingInHTML(driver);
		MasteringJavaScript masteringJavaScript= new MasteringJavaScript(driver);
		
		
		if(arrivalssize == 3)
		{
		seleniumRuby.clickOnSeleniumRubyImage();
		driver.navigate().back();
		thinkingInHTML.clickOnThinkingInHTMLImage();
		driver.navigate().back();
		masteringJavaScript.clickOnMasteringJavaScriptImage();
		driver.navigate().back();
		System.out.println("Test Case is passed.");
		}
		else
		{
			System.out.println("Test case is failed!");
		
		}
		
		
		//6.Test case 4 - Home page-Arrival Images Discription
		
		shop.clickOnShop();
		home.clickOnHome();
		
		if(arrivalssize == 3)
		{
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
			
			System.out.println("Test Case is passed.");
		}
		else
		{
			System.out.println("Test case is failed!");
		
		}
		
		
		
	driver.close();	
		
		
	}

}
