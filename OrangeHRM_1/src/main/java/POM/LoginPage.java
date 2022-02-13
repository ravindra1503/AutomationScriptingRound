package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	// https://opensource-demo.orangehrmlive.com/
	@FindBy (xpath="//input[@id='txtUsername']")
	private WebElement username;

	@FindBy (xpath="//input[@id='txtPassword']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='btnLogin']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToOrangeHrmUsername(String usern)
	{
		username.sendKeys(usern);
	
		
	}
	
	public void loginToOrangeHrmPassword(String pass)
	{
		password.sendKeys(pass);;
	}
	
	public void loginButtonToOrangeHrm()
	{
		loginButton.click();
	}
	
	public void loginToOrangeHrm()
	{
		username.sendKeys("Admin");
	
		password.sendKeys("admin123");
	
		loginButton.click();
	}
	
}
