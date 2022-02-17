package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookBasket {
	private WebDriver driver;
	
	@FindBy (xpath="//input[@type='number']")
	private WebElement inputHighestQuantityForBook;
	
	@FindBy (xpath="//input[@name='update_cart']")
	private WebElement clickUpdateBasketButton;
	
	@FindBy (xpath="//input[@name='coupon_code']")
	private WebElement couponCoc;
	
	@FindBy (xpath="//input[@name='apply_coupon']")
	private WebElement clickApplyButton;
	
	
	
	
	
	public BookBasket(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	
	public void addQuantity()
	{
		inputHighestQuantityForBook.sendKeys("7934");;
	}
	
	public void clickUpdateBasket()
	{
		clickUpdateBasketButton.click();
	}
	
	public void enterCouponCodeAndClickApply()
	{
		couponCoc.sendKeys("krishnasakinala");
		clickApplyButton.click();
	}
	
	
	
}
