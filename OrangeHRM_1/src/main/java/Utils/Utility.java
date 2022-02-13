package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	
	public static String getDataFromExcelSheet(String excelSheet, int row , int cell) throws EncryptedDocumentException, IOException
	{
		String path="F:\\Automation Testing\\LoginDetails.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		Sheet sheet=WorkbookFactory.create(file).getSheet(excelSheet);
		String data=sheet.getRow(row).getCell(cell).getStringCellValue();
		
		return data;

	}
	
	public static void takeScreenshotFailedTestCase(WebDriver driver , int testID) throws IOException
	{
		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		LocalDateTime ld=LocalDateTime.now();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("ddMMyyyy_HHmmssS");
		String date=ld.format(df);
		File destination= new File("F:\\Automation Testing\\Screenshot\\OrangeHRMSFailedTestCaseScreenShot\\OrangeHRM"+testID+"_"+date+".png");
		FileHandler.copy(src, destination);
		
		
	}
	
	
	
	
}
