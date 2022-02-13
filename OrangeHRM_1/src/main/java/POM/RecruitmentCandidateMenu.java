package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RecruitmentCandidateMenu 
{
	
	private WebDriver driver;
	
	@FindBy (xpath="//select[@id='candidateSearch_jobTitle']")
	private WebElement jobTitle;
	
	@FindBy (xpath= "//select[@id='candidateSearch_jobVacancy']")
	private WebElement  vacancy;
	
	@FindBy (xpath= "//select[@id='candidateSearch_hiringManager']")
	private WebElement hiringManager ;
	
	@FindBy (xpath="//select[@id='candidateSearch_status']" )
	private WebElement  status;
	
	@FindBy (xpath= "//input[@id='candidateSearch_candidateName']")
	private WebElement candidateName ;
	
	@FindBy (xpath="//input[@id='candidateSearch_keywords']" )
	private WebElement keywords ;
	
	@FindBy (xpath= "//input[@id='candidateSearch_fromDate']")
	private WebElement fromDateOfApplication ;
	
	@FindBy (xpath= "//select[@data-handler='selectMonth']")
	private WebElement fromMonthDateOfApplication ;
	
	@FindBy (xpath= "//a[text()='15']")
	private WebElement fromDayDateOfApplication ;
	
	@FindBy (xpath= "//input[@id='candidateSearch_toDate']")
	private WebElement toDateOfApplication ;
	
	@FindBy (xpath= "//select[@data-handler='selectMonth']")
	private WebElement toMonthDateOfApplication ;
	
	@FindBy (xpath="//a[text()='20']")
	private WebElement toDayDateOfApplication ;
	
	@FindBy (xpath= "//select[@id='candidateSearch_modeOfApplication']")
	private WebElement methodOfApllication ;
	
	@FindBy (xpath="/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr" )
	private List<WebElement> rowOfCandidateApplicationTable ;
	
	@FindBy (xpath= "/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr/th")
	private List<WebElement> coloumOfCandidateApplicationTable ;
	
	
	
	public RecruitmentCandidateMenu(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void recruitmentCandidateSearch()
	{
		
		
		dropdown(jobTitle).selectByVisibleText("Automation Tester");
		
		dropdown(vacancy).selectByVisibleText("All");
		
		dropdown(hiringManager).selectByVisibleText("All");
		
		dropdown(status).selectByVisibleText("Shortlisted");
		
		candidateName.sendKeys("Tom");
		
		keywords.sendKeys("TPA");
		
		//Date Selection
		fromDateOfApplication.click();		
		dropdown(fromMonthDateOfApplication).selectByVisibleText("Mar");
		fromDayDateOfApplication.click();
		
		
		toDateOfApplication.click();
		dropdown(toMonthDateOfApplication).selectByVisibleText("Dec");
		toDayDateOfApplication.click();
		
		
		dropdown(methodOfApllication).selectByVisibleText("Manual");
		
		
		int tableRow=rowOfCandidateApplicationTable.size();		
		int tableColums=coloumOfCandidateApplicationTable.size();
		System.out.println("Total Rows in table"+tableRow);
		System.out.println("Total Columns in table"+tableColums);
		
		for(int i=1;i<=tableRow;i++)
		{
			for(int j=2;j<=tableColums;j++)
			{
				String value=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(value+"     ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
	public Select dropdown(WebElement element)
	{
		Select sl=new Select(element);
		return sl;
		
	}
	
	
	
	
}
