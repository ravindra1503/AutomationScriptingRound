package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeAut6 {

	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation Testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
		//Test case 1 - home page with 3 sliders
		/*1) Open the browser
		  2) Enter the URL “http://practice.automationtesting.in/”
		  3) Click on Shop Menu
		  4) Now click on Home menu button
    	  5) Test whether the Home page has Three Sliders only
		  6) The Home page must contains only three sliders */
				
		driver.findElement(By.xpath("//a[text()='Shop']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		int slidesize=driver.findElements(By.xpath("//div[@data-gutter='gutter-default']")).size();
		System.out.println(slidesize);
		if(slidesize == 3)
			System.out.println("Test Case is passed.");
		else 
			System.out.println("Test case is failed!");
		
		
		
		
		
		//Test case 2 - Home page with 3 arrivals
	/*	1) Open the browser
		2) Enter the URL “http://practice.automationtesting.in/”
		3) Click on Shop Menu
		4) Now click on Home menu button
		5) Test whether the Home page has Three Arrivals only
		6) The Home page must contains only three Arrivals  */
		
		
		driver.findElement(By.xpath("//a[text()='Shop']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		WebElement el=driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']"));
		PracticeAut6.scrolltillelement(driver, el);
		int arrivalsize=driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]//img")).size();
		System.out.println(arrivalsize);
		if(arrivalsize == 3)
			System.out.println("Test Case is passed.");
		else 
			System.out.println("Test case is failed!");
		
		
		
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
		*/
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Shop']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		WebElement el1=driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']"));
		PracticeAut6.scrolltillelement(driver, el1);
		int arrivalsize1=driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]//img")).size();
		System.out.println(arrivalsize1);
		if(arrivalsize1 == 3)
		{
			driver.findElement(By.xpath("//img[@title='Selenium Ruby']")).click();
			driver.navigate().back();
			driver.findElement(By.xpath("//img[@title='Thinking in HTML']")).click();
			driver.navigate().back();
			driver.findElement(By.xpath("//img[@title='Mastering JavaScript']")).click();
			driver.navigate().back();
			Thread.sleep(2000);
			System.out.println("Test Case is passed.");
		}
		else 
		{
			System.out.println("Test case is failed!");
		}
		
		//Test case 4 - Home page-Arrival Images Discription
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Shop']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		WebElement el2=driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']"));
		PracticeAut6.scrolltillelement(driver, el2);
		int arrivalsize2=driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]//img")).size();
		System.out.println(arrivalsize2);
		if(arrivalsize2 == 3)
		{
			driver.findElement(By.xpath("//img[@title='Selenium Ruby']")).click();
			driver.findElement(By.xpath("//a[text()='Description']")).click();
			String description=driver.findElement(By.xpath("(//div[@id='tab-description'])//p")).getText();
				if(description.contains("Selenium WebDriver Recipes book is a quick problem-solving guide"))
				{
					System.out.println("Test Case is passed for description available for 1st image");
				}
			driver.navigate().back();
			driver.findElement(By.xpath("//img[@title='Thinking in HTML']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='Description']")).click();
			String description2=driver.findElement(By.xpath("(//div[@title='Page 7'])//p")).getText();
				if(description2.contains("This book provides you with an intermediate knowledge of HTML"))
				{
					System.out.println("Test Case is passed for description available for 2nd image");
				}
			driver.navigate().back();
			driver.findElement(By.xpath("//img[@title='Mastering JavaScript']")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='Description']")).click();
			String description3=driver.findElement(By.xpath("(//div[@title='Page 14'])//p")).getText();
			
				if(description3.contains("it is difficult to find a topic related to JavaScript that has not been discussed"))
				{
					System.out.println("Test Case is passed for description available for 3rd image");
				}
			driver.navigate().back();
			
		}
			else 
			System.out.println("Test case is failed!");
		
		
		
		
		
		
		
	}
	
	public static void scrolltillelement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	

}
