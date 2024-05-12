package packAE1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//h2[@data-qa='account-created']")
	private WebElement accountCreatedMsg;
	
	@FindBy (xpath = "//a[@data-qa='continue-button']")
	private WebElement continueButton;

	
	public AccountCreatedPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void accountCreatedMsgVerification()
	{
		
			String accCreatedSuccessMessage = accountCreatedMsg.getText();
			if(accCreatedSuccessMessage.equals("Account Created!"))
			{
				System.out.println("Step 4 - Account is created successfully");
			}
			else
			{
				System.out.println("Step 4 - There is a problem in account creation");
	
			}
		
		
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
}
