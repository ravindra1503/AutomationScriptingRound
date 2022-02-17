package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//Test case 1 - home page with 3 sliders
		/*1) Open the browser
		  2) Enter the URL “http://practice.automationtesting.in/”
		  3) Click on Shop Menu
		  4) Now click on Home menu button
  	  5) Test whether the Home page has Three Sliders only
		  6) The Home page must contains only three sliders */


public class Sliders {
	
	@FindBy (xpath="//div[@data-gutter='gutter-default']")
	private List<WebElement> sliders;
 
	
	public Sliders(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public int sliderSize()
	{
		int sizeOfSliders=sliders.size();
//		if(sizeOfSliders == 3)
//			System.out.println("Test Case is passed.");
//		else 
//			System.out.println("Test case is failed!");
		return sizeOfSliders;
	}
	
	
	
	
}


