package POM;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeProjectinfoCustomers 
{
	private WebDriver driver;
	@FindBy (xpath="//div[@id='tableWrapper']//table//tbody//tr")
	private List<WebElement> tableRowSize;
	
	@FindBy (xpath="//div[@id='tableWrapper']//table//thead//tr//th")
	private List<WebElement> tablecolumnSize;
	
	
	public TimeProjectinfoCustomers(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void printCustomerTable()
	{
		int customertablerowsize=tableRowSize.size();
		int customertablecolumnsize=tablecolumnSize.size();
		
		for(int i=1; i<=customertablerowsize;i++)
		{
			for(int j=1;j<=customertablecolumnsize;j++)
			{
				String element=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/form/div[4]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(element+"                      ");
				
			}
			System.out.println();
		}
		
		
		
	}
	
	
	

}
