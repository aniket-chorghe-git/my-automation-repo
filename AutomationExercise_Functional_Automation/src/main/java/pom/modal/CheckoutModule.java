package pom.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutModule {

private WebDriver driver;
		
	@FindBy (xpath = "//u[text()='Register / Login']")
	private WebElement registerORLoginLink;

	
	//Constructor - public only
	public CheckoutModule(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods - Public only
	public void clickOnRegisterOrLoginButton()
	{
		registerORLoginLink.click();
	}
	
}
