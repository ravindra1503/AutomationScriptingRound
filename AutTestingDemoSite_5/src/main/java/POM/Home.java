package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	@FindBy (xpath="//a[text()='Home']")
	private WebElement homeButton;
	
	public Home (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnHome()
	{
		homeButton.click();
	}
}
