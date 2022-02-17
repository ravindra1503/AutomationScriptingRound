package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shop 
{
//http://practice.automationtesting.in/
	
	@FindBy (xpath="//a[text()='Shop']")
	private WebElement shopButton;
	
	public Shop (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnShop()
	{
		shopButton.click();
	}
	
	
	
}
