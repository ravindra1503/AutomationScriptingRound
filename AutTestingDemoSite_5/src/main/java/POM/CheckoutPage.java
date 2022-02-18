package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	private WebDriver driver;

	@FindBy (xpath="//input[@id='billing_first_name']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@id='billing_last_name']")
	private WebElement lastName;
	
	
	@FindBy (xpath="//input[@id='billing_company']")
	private WebElement billingCompanyName;
	
	
	@FindBy (xpath="//input[@id='billing_email']")
	private WebElement emailAddress;
	
	@FindBy (xpath="//input[@id='billing_phone']")
	private WebElement phoneNumber;
	
	@FindBy (xpath="//a[@class='select2-choice']")
	private WebElement clickToSelectCountry;
	
	
	@FindBy (xpath="//input[@id='s2id_autogen1_search']")
	private WebElement inputCountryName;
	
	@FindBy (xpath="(//span[@class='select2-match'])[2]")
	private WebElement selectCountryCorrectName;
	
	@FindBy (xpath="//input[@id='billing_address_1']")
	private WebElement enterStreetAddress;
	
	@FindBy (xpath="//input[@id='billing_address_2']")
	private WebElement enterAppartmentAddress;
	
	@FindBy (xpath="//input[@id='billing_city']")
	private WebElement enterTownCity;
	
	
	@FindBy (xpath="//a[@class='select2-choice select2-default']")
	private WebElement clickToSelectStateCountry;
	
	@FindBy (xpath="//input[@id='s2id_autogen2_search']")
	private WebElement inputStateCountryName;
	
	@FindBy (xpath="//div[@id='select2-result-label-4050']")
	private WebElement selectStateCountryCorrectName;
	
	
	@FindBy (xpath="//input[@id='billing_postcode']")
	private WebElement enterPostcode;
	
	@FindBy (xpath="//a[@class='showcoupon']")
	private WebElement clickToEnterCouponCode;
	
	@FindBy (xpath="//input[@id='coupon_code']")
	private WebElement applyCouponOnCheckOutPage;
	
	@FindBy (xpath="//input[@name='apply_coupon']")
	private WebElement clickOnApplyCoupon;
	
	@FindBy (xpath="//input[@id='payment_method_cheque']")
	private WebElement orderPaymentMethodChequePayment;
	
	@FindBy (xpath="//input[@id='place_order']")
	private WebElement clickOnPlaceOrder;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	
	public void fillCheckoutBillingDetails()
	{
		clickToEnterCouponCode.click();
		applyCouponOnCheckOutPage.sendKeys("krishnasakinala");
		clickOnApplyCoupon.click();
		
		firstName.sendKeys("ABCDE");
		lastName.sendKeys("GHEJK");
		billingCompanyName.sendKeys("ABCDEFGHKLM");
		emailAddress.sendKeys("ABCDE@abc.com");
		phoneNumber.sendKeys("0123456789");
		clickToSelectCountry.click();
		inputCountryName.sendKeys("India");
		selectCountryCorrectName.click();
		enterStreetAddress.sendKeys("ABCDEF");
		enterAppartmentAddress.sendKeys("111");
		enterTownCity.sendKeys("CDEF");
		clickToSelectStateCountry.click();
		inputStateCountryName.sendKeys("Maharashtra");
		selectStateCountryCorrectName.click();
		enterPostcode.sendKeys("123456");
		
		orderPaymentMethodChequePayment.click();
		clickOnPlaceOrder.click();
		
	}
	
	
	
	
}
