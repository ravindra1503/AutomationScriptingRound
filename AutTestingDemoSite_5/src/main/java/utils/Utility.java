package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	
	public static void takeScreenshotOfFailedTC(WebDriver driver , int testID) throws IOException
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		LocalDateTime ld = LocalDateTime.now();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("ddMMyyyy_HHmmssS");
		String date=ld.format(df);		
		File dest=new File("F:\\Automation Testing\\Screenshot\\Project5\\FailedTestCaseID"+testID+"_"+date+".png");
		FileHandler.copy(src, dest);
	
	
	
	}
	
}
