package TestClass1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Browser;
import POM.BuzzMenu;
import POM.LoginPage;
import POM.MenuOfOrangeHRM;
import POM.PIMAddEmployee;
import POM.RecruitmentCandidateMenu;
import POM.TimeProjectinfoCustomers;
import Utils.Utility;

public class TestClassWithTestNG extends Browser
{
	private WebDriver driver;
	private MenuOfOrangeHRM menuOfOrangeHrm;
	private SoftAssert softAssert;
	private LoginPage loginPage;
	private TimeProjectinfoCustomers timeProjectinfoCustomers;
	private PIMAddEmployee pimAddEmployee;
	private RecruitmentCandidateMenu recruitmentCandidateMenu;
	private BuzzMenu buzzMenu;
	private int TestID;
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowserforTestClass(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=launchChromeBrowser();
		}
		if(browser.equalsIgnoreCase("Firefox"))
		{
			driver =launchFirefoxBrowser();
		}
		
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		
		menuOfOrangeHrm= new MenuOfOrangeHRM(driver);
		loginPage=new LoginPage(driver);
		pimAddEmployee=new PIMAddEmployee(driver);
		timeProjectinfoCustomers=new TimeProjectinfoCustomers(driver);
		recruitmentCandidateMenu=new RecruitmentCandidateMenu(driver);
		buzzMenu=new BuzzMenu(driver);
		
	}
	
	
	
	
	@BeforeMethod
	public void beforeMethod() throws EncryptedDocumentException, IOException
	{	
		
		
		String user = Utility.getDataFromExcelSheet("Sheet1", 0, 0);
		loginPage.loginToOrangeHrmUsername(user);
		
		
		String pass = Utility.getDataFromExcelSheet("Sheet1", 0, 1);
		loginPage.loginToOrangeHrmPassword(pass);
		
		loginPage.loginButtonToOrangeHrm();
		
	}
	
	
	@Test(priority=1)
	public void verifyTitleAfterLogin()
	{
		TestID=101;
		softAssert=new SoftAssert();
		menuOfOrangeHrm= new MenuOfOrangeHRM(driver);
		String title=driver.getTitle();
		softAssert.assertEquals(title, "OrangeHRM");
		
		softAssert.assertAll();
	}
	
	@Test
	public void verifyFillAddEmployeeForm() throws FindFailed, InterruptedException
	{
		TestID=102;
		softAssert=new SoftAssert();
		menuOfOrangeHrm= new MenuOfOrangeHRM(driver);
		menuOfOrangeHrm.clickOnPIMMenu();
		menuOfOrangeHrm.clickOnPIMSubMenuAddEmployee();
		pimAddEmployee.fillAddEmployeedetails();
		boolean saveButton=driver.findElement(By.xpath("//input[@id='btnSave']")).isEnabled();
		softAssert.assertTrue(saveButton);
		softAssert.assertAll();
	}
	
	@Test
	public void verifyPrintCustomerTable()
	{
		TestID=103;
		menuOfOrangeHrm.clickOnTimeMenu();
		menuOfOrangeHrm.clickOnTimeSubProject();
		menuOfOrangeHrm.clickOnTimeSubProjectSubCustomer();
		
		
		timeProjectinfoCustomers.printCustomerTable();
	}
	
	@Test
	public void verifyRecruitmentCandidateSearch()
	{
		TestID=104;
		
		menuOfOrangeHrm.clickOnRecruitmentMenu();
		menuOfOrangeHrm.clickOnRecruitmentSubCandidate();
		
		
		recruitmentCandidateMenu.recruitmentCandidateSearch();
	}
	
	@Test
	public void verifyTakeScreenShotOnBuzz() throws IOException, InterruptedException
	{
		TestID=105;
		menuOfOrangeHrm.clickOnBuzzMenu();
		
		buzzMenu.takeScreenshotOfMostCommentedPost();
	}
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshotFailedTestCase(driver, TestID);
		}
		menuOfOrangeHrm.logoutFromApplication();
	}
	
	
	@AfterClass
	public void afterClass()
	{
		
		menuOfOrangeHrm= null;
		loginPage=null;
		pimAddEmployee=null;
		timeProjectinfoCustomers=null;
		recruitmentCandidateMenu=null;
		buzzMenu=null;
		
	}

	@AfterTest
	public void afterSuit()
	{
		driver.quit();	
		driver=null;
		System.gc();
	}
	
	
	
}
