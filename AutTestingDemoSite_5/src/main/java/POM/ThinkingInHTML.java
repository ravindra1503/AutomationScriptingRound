package POM;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//Test case 3 - Home page-images in arrivals should navigate
	/*	1) Open the browser
		2) Enter the URL “http://practice.automationtesting.in/”
		3) Click on Shop Menu
		4) Now click on Home menu button
		5) Test whether the Home page has Three Arrivals only
		6) The Home page must contains only three Arrivals
		7) Now click the image in the Arrivals
		8) Test whether it is navigating to next page where the user can add that book into his basket.
		9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
		10-Home page-Arrival Images Discription  
		*/

public class ThinkingInHTML {
	
	private WebDriverWait wait;
	private WebDriver driver;
	@FindBy (xpath="//img[@title='Thinking in HTML']")
	private WebElement thinkInHTMLImage;
	
	@FindBy (xpath="//a[text()='Description']")
	private WebElement clickOnThinkInHTMLDescription;
	
	@FindBy (xpath="(//div[@title='Page 7'])//p")
	private WebElement descriptionOfThinkInHTML;
	
	
	public ThinkingInHTML(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,10);
		
	}
	
	
	public void clickOnThinkingInHTMLImage()
	{
		thinkInHTMLImage.click();
	}
	
	public String verifyThinkingInHTMLDescription()
	{
		wait.until(ExpectedConditions.visibilityOf(clickOnThinkInHTMLDescription));
		
		clickOnThinkInHTMLDescription.click();
		
		String DescriptionThinkingInHTMLPage=descriptionOfThinkInHTML.getText();
		return DescriptionThinkingInHTMLPage;
	}
	
}
