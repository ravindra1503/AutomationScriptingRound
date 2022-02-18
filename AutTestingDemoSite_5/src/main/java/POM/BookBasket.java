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
	
	@FindBy (xpath="//a[@class='remove']")
	private WebElement clickRemoveBookIcon;
	
	@FindBy (xpath="//p[@class='cart-empty']")
	private WebElement bookRemovedMessage;
	
	@FindBy (xpath="(//span[@class='woocommerce-Price-amount amount'])[2]")
	private WebElement checkTotalPrice;
	
	@FindBy (xpath="(//span[@class='woocommerce-Price-amount amount'])[3]")
	private WebElement basketTotalsSubTotalPrice;
	
	@FindBy (xpath="(//span[@class='woocommerce-Price-amount amount'])[5]")
	private WebElement basketTotalsTotalPrice;
	
	@FindBy (xpath="//a[@class='checkout-button button alt wc-forward']")
	private WebElement proceedToCheckoutButton;
	
	
	public BookBasket(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	
	public void addQuantity()
	{
		inputHighestQuantityForBook.clear();
		inputHighestQuantityForBook.sendKeys("2");;
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
	
	public String clickRemoveThisBookIcon()
	{
		clickRemoveBookIcon.click();
		String bookRemoveMessage=bookRemovedMessage.getText();
		return bookRemoveMessage;
	
	}
	
	public void checkTotalPriceOfBook()
	{
		System.out.println(checkTotalPrice);
	}
	
	public boolean compareTotalSubTotalPrice()
	{
		boolean price;
		String basketTotalSubTotalPrice = basketTotalsSubTotalPrice.getText();
		String subTotalPriceOfBook=basketTotalSubTotalPrice.substring(1);

		float  subTotal=Float.parseFloat(subTotalPriceOfBook);
		System.out.println(subTotal);
		
		
		String basketTotalTotalPrice = basketTotalsTotalPrice.getText();
		String totalPriceOfBook= basketTotalTotalPrice.substring(1);
		float  totalPrice=Float.parseFloat(totalPriceOfBook);
		System.out.println(totalPrice);
		
		if(totalPrice<subTotal)
			price=true;
		else
			price=false;
		
		return price;
		
	}
	
	public void clickOnCheckoutButton()
	{
		proceedToCheckoutButton.click();
	}
	
	
	
	
	
	
}
