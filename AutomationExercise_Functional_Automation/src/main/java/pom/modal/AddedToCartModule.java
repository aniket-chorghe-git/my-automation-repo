package pom.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddedToCartModule {

	private WebDriver driver;
	
	@FindBy (xpath = "//u[text()='View Cart']")
	private WebElement viewCartLink;
	
	@FindBy (xpath = "//button[text()='Continue Shopping']")
	private WebElement continueShoppingButton;
	
	//Constructor - public only
	public AddedToCartModule(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods - Public only
	public void clickOnContinueShopping()
	{
		continueShoppingButton.click();
	}
	
	public void viewCart()
	{
		viewCartLink.click();
	}
	
}
