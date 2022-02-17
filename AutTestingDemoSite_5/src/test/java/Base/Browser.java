package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	
	public static WebDriver lanuchChormeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Automation Testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
	public static WebDriver lanuchFirefoxBrowser()
	{
		
		System.setProperty("webdriver.gecko.driver", "F:\\Automation Testing\\Selenium\\Firefox\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
		
	}

}
