package packAE1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentPage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//input[@name='name_on_card']")
	private WebElement nameOnCardField;
	
	@FindBy (xpath = "//input[@name='card_number']")
	private WebElement cardNumberField;
	
	@FindBy (xpath = "//input[@name='cvc']")
	private WebElement cardCVCField;
	
	@FindBy (xpath = "//input[@name='expiry_month']")
	private WebElement expiryMonthField;
	
	@FindBy (xpath = "//input[@name='expiry_year']")
	private WebElement expiryYearField;
	
	@FindBy (xpath = "//button[@id='submit']")
	private WebElement submitPaymentDetailsButton;
	
	@FindBy (xpath = "(//div[@class='alert-success alert'])[1]")
	private WebElement paymentSuccessMsg;
	
	
	
	public PaymentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void submitPaymentDetails() 
	{
		nameOnCardField.sendKeys("Aniket Chorghe");
		cardNumberField.sendKeys("123123456");
		cardCVCField.sendKeys("311");
		expiryMonthField.sendKeys("09");
		expiryYearField.sendKeys("2025");
		submitPaymentDetailsButton.click();
		
		
		String paymentDoneMsg1 = paymentSuccessMsg.getText();
//		boolean paymentDoneMsg2 =  paymentDoneMsg1.equals("success_message");
		System.out.println(paymentDoneMsg1);
		
//		if(paymentDoneMsg2==true)
//		{
//			System.out.println("Step 6 - Payment has been done");
//		}
//		else
//		{
//			System.out.println("Step 6 - Payment error");
//
//		}
		
//		Assert.assertEquals(paymentDoneMsgFinal, true, "Order has been placed");
		
	}
	
	
	
	
	
	// 
	
	

}
