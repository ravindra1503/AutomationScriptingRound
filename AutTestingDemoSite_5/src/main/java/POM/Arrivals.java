package POM;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//Test case 2 - Home page with 3 arrivals
	/*	1) Open the browser
		2) Enter the URL “http://practice.automationtesting.in/”
		3) Click on Shop Menu
		4) Now click on Home menu button
		5) Test whether the Home page has Three Arrivals only
		6) The Home page must contains only three Arrivals  */


public class Arrivals {
	//http://practice.automationtesting.in/
	
	@FindBy (xpath="/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]//img")
	private List<WebElement> arrival;
	
	
	public Arrivals(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public int arrivalSize()
	{
		int sizeOfArrivals=arrival.size();
//		if(sizeOfArrivals == 3)
//			System.out.println("Test Case is passed.");
//		else 
//			System.out.println("Test case is failed!");
		return sizeOfArrivals;
		
	}

}


