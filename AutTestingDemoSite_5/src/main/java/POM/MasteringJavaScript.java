package POM;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MasteringJavaScript {
	
	private WebDriverWait wait;
	private WebDriver driver;
	@FindBy (xpath="//img[@title='Mastering JavaScript']")
	private WebElement masteringJavascriptImage;
	
	@FindBy (xpath="//a[text()='Description']")
	private WebElement clickOnMasteringJavascriptDescription;
	
	@FindBy (xpath="(//div[@title='Page 14'])//p")
	private WebElement descriptionOfMasteringJavascript;
	
	@FindBy (xpath="//a[text()='Reviews (0)']")
	private WebElement reviewsOfMasteringJavaScript;
	
	@FindBy (xpath="//button[text()='Add to basket']")
	private WebElement addBookToBasket;
	
	@FindBy (xpath="//input[@type='number']")
	private WebElement inputHighestQuantityForBook;
	
		
	
	public MasteringJavaScript(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,10);
	}
	
	public void clickOnMasteringJavaScriptImage()
	{
		masteringJavascriptImage.click();
	}
	
	public String verifyMasteringJavaScriptDescription()
	{
		wait.until(ExpectedConditions.visibilityOf(clickOnMasteringJavascriptDescription));
		clickOnMasteringJavascriptDescription.click();
		String DescriptionMasteringJavaScriptPage=descriptionOfMasteringJavascript.getText();
		return DescriptionMasteringJavaScriptPage;
	}
	
	public void verifyMasteringJavascriptReviews()
	{
		reviewsOfMasteringJavaScript.click();
		
	}
	
	public void addMasteringJavascriptBookToBasket(String NumberOfBooks)
	{
		inputHighestQuantityForBook.sendKeys(NumberOfBooks);
		addBookToBasket.click();
		
	}
	
	
}
