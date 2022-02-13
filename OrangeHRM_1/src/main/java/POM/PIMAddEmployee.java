package POM;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class PIMAddEmployee 
{
	
	@FindBy (xpath="(//input[@class='formInputText'])[1]")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@name='middleName']")
	private WebElement middleName;
	
	@FindBy (xpath="//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy (xpath="//input[@name='employeeId']")
	private WebElement employeeId;
	
	@FindBy (xpath="//label[text()='Photograph']")
	private WebElement uploadPhotoFile;
	
	@FindBy (xpath="//label[@for='chkLogin']")
	private WebElement createLogincheckbox;
	
	@FindBy (xpath="//input[@id='user_name']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@id='user_password']")
	private WebElement userPassword;
	
	@FindBy (xpath="//input[@id='re_password']")
	private WebElement confirmUserPassword;
	
	@FindBy (xpath="//select[@id='status']")
	private WebElement statusOfUserId;
	
	public PIMAddEmployee(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void fillAddEmployeedetails() throws InterruptedException, FindFailed
	{
		firstName.sendKeys("ABCDE");
		middleName.sendKeys("CDE");
		lastName.sendKeys("FGHN");
		
		employeeId.clear();
		employeeId.sendKeys("20001988");
		
		
		uploadPhotoFile.click();
		Screen sc=new Screen();
		Pattern fileinput=new Pattern("F:\\Automation Testing\\Text.PNG");
		Pattern btnopen=new Pattern("F:\\Automation Testing\\openbt.PNG");
		sc.wait(fileinput, 10);
		sc.type(fileinput, "F:\\Automation Testing\\demo.png");
		sc.click(btnopen);
		
		createLogincheckbox.click();
	
		userName.sendKeys("ABC");
		userPassword.sendKeys("abc");
		confirmUserPassword.sendKeys("abc");
		
		Select status=new Select(statusOfUserId);
		status.selectByVisibleText("Disabled");
		Thread.sleep(2500);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
