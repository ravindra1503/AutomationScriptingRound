package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	
private WebDriver driver;
	
	@FindBy (xpath="//a[@class='wpmenucart-contents']")
	private WebElement clickMenuAddBookToBasket;
	
	@FindBy (xpath="//a[text()='Shop']")
	private WebElement shopButton;
	
	@FindBy (xpath="//a[text()='Home']")
	private WebElement homeButton;
	
	public MenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	
	public void clickMenuBasket()
	{
		clickMenuAddBookToBasket.click();
	}
	
	public void clickOnShop()
	{
		shopButton.click();
	}
	
	public void clickOnHome()
	{
		homeButton.click();
	}
	
	

}
