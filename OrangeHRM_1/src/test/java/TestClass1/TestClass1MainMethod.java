package TestClass1;

import java.io.IOException; 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;

import POM.BuzzMenu;
import POM.LoginPage;
import POM.MenuOfOrangeHRM;
import POM.PIMAddEmployee;
import POM.RecruitmentCandidateMenu;
import POM.TimeProjectinfoCustomers;

public class TestClass1MainMethod {
public static void main(String[] args) throws FindFailed, InterruptedException, IOException {
	
	System.setProperty("webdriver.chrome.driver", "F:\\Automation Testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Login to Application
	LoginPage loginPage=new LoginPage(driver);
	loginPage.loginToOrangeHrm();
	
	//Menu of Application
	MenuOfOrangeHRM menuOfOrangeHrm= new MenuOfOrangeHRM(driver);
	menuOfOrangeHrm.clickOnPIMMenu();
	menuOfOrangeHrm.clickOnPIMSubMenuAddEmployee();
	
	
	
	//1st Page of PIM-Add Employee
	PIMAddEmployee pimAddEmployee=new PIMAddEmployee(driver);
	pimAddEmployee.fillAddEmployeedetails();
	
	//2nd Page of Time - Project Info - Customers
	menuOfOrangeHrm.clickOnTimeMenu();
	menuOfOrangeHrm.clickOnTimeSubProject();
	menuOfOrangeHrm.clickOnTimeSubProjectSubCustomer();
	
	TimeProjectinfoCustomers timeProjectinfoCustomers=new TimeProjectinfoCustomers(driver);
	timeProjectinfoCustomers.printCustomerTable();
	
	
	//3rd Page Recruitment - Candidates
	menuOfOrangeHrm.clickOnRecruitmentMenu();
	menuOfOrangeHrm.clickOnRecruitmentSubCandidate();
	
	RecruitmentCandidateMenu recruitmentCandidateMenu=new RecruitmentCandidateMenu(driver);
	recruitmentCandidateMenu.recruitmentCandidateSearch();
		
	
	//4th page Buzz 
	menuOfOrangeHrm.clickOnBuzzMenu();
	
	BuzzMenu buzzMenu=new BuzzMenu(driver);
	buzzMenu.takeScreenshotOfMostCommentedPost();
	
	
	// 5th Logout from Application
	menuOfOrangeHrm.logoutFromApplication();
	
	
}
}
