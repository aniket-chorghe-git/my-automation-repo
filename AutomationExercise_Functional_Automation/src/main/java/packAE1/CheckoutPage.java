package packAE1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
WebDriver driver;
	
	@FindBy (xpath = "//textarea[@name='message']")
	private WebElement commentInputField;
	
	@FindBy (xpath = "//a[text()='Place Order']")
	private WebElement placeOrderButton;


	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void addCommentInTheBox()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", commentInputField);
		
		commentInputField.sendKeys("No comments from the user");
		
		placeOrderButton.click();
	}

}
