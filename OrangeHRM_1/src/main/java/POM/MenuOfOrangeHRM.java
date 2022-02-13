package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuOfOrangeHRM 
{
	//PIM- AddEmployee 
	//Time - Project Info - Customers
	//Performance - Empployee Tracker
	//Buzz
	//Recruitment - Candidates
	
	private Actions act;
	private WebDriver driver;
	
	@FindBy (xpath="//*[text()='PIM']")
	private WebElement pimMenu;
	
	@FindBy (xpath="//a[text()='Add Employee']")
	private WebElement pimSubMenuAddEmployee;
	
	@FindBy (xpath="//a[@id='menu_time_viewTimeModule']")
	private WebElement timeMenu;
	
	@FindBy (xpath="//a[@id='menu_admin_ProjectInfo']")
	private WebElement timeSubMenuProjectInfo;
	
	@FindBy (xpath="//a[@id='menu_admin_viewCustomers']")
	private WebElement timeSubMenuProjectInfoSubMenuCustomers;
	
	@FindBy (xpath="//b[text()='Buzz']")
	private WebElement buzzMenu;
	
	@FindBy (xpath="//b[text()='Recruitment']")
	private WebElement recruitmentMenu;
	
	
	@FindBy (xpath="//a[text()='Candidates']")
	private WebElement recruitmentSubMenuCandidates;
	
	
	@FindBy (xpath="//a[@id='welcome']")
	private WebElement logoutMenu;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logout;
	
	
	
	//Constructor of class - applying Encapsulation by declaring global variable as Private and in constructor referring them by keyword this
	public MenuOfOrangeHRM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
	}
	
	//Method PIM- AddEmployee 
	public void clickOnPIMMenu()
	{
		pimMenu.click();
	}
	
	public void clickOnPIMSubMenuAddEmployee()
	{
		pimSubMenuAddEmployee.click();
	}
	
	 //Time - Project Info - Customers
		
	public void clickOnTimeMenu()
	{
		timeMenu.click();
	}
	
	public void clickOnTimeSubProject()
	{
		timeSubMenuProjectInfo.click();
	}
	
	public void clickOnTimeSubProjectSubCustomer()
	{
		timeSubMenuProjectInfoSubMenuCustomers.click();
	}
	
		
	//Buzz
	
	public void clickOnBuzzMenu()
	{
		buzzMenu.click();
	}
	
	
	//Recruitment - Candidates
	public void clickOnRecruitmentMenu()
	{
		recruitmentMenu.click();
	}
	public void clickOnRecruitmentSubCandidate()
	{
		recruitmentSubMenuCandidates.click();
	}
	
	
	
	public void logoutFromApplication() throws InterruptedException
	{
		logoutMenu.click();
		Thread.sleep(2000);
		logout.click();
	}
	
	
	
	
	
}
