package POM;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzMenu {
	// https://opensource-demo.orangehrmlive.com/
	private WebDriver driver;
	@FindBy (xpath="(//div[@class='rightBarHeading'])[2]")
	private WebElement mostCommentedPost;
	
	@FindBy (xpath="//img[@id='1_3']")
	private WebElement clickOnFirstImage;
	
	@FindBy (xpath="//img[@id='shareViewMoreMod3_']")
	private WebElement closeImage;
	
	public BuzzMenu(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void takeScreenshotOfMostCommentedPost() throws IOException, InterruptedException
	{
		mostCommentedPost.click();
		clickOnFirstImage.click();
		File sorce=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Random random=new Random();
		int randomnum=random.nextInt();
		File destination=new File("F:\\Automation Testing\\Screenshot\\orangepostMostViedPhoto"+randomnum+".png");
		FileHandler.copy(sorce, destination);
		Thread.sleep(2000);
		closeImage.click();
		
		
	}

}
