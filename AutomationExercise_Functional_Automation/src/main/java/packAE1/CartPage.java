package packAE1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
private WebDriver driver;
	
	@FindBy (xpath = "//a[text()='Proceed To Checkout']") private WebElement proceedToCheckoutButton;
	@FindBy (xpath = "//div[@id='cart_info']") private WebElement cartInfo;
	@FindBy (xpath = "(//td[@class='cart_description'])[1]") private WebElement ItemNameInCart;
	
	//Constructor - public only
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods - Public only
	public String cartPageGetURL()
	{
		String cartPageURL = driver.getCurrentUrl();
		return cartPageURL;
		
	}
	
	public void productVerificationIntoCart()
	{
		int cartRowCount = driver.findElements(By.xpath("//table[@id='cart_info_table']//tr")).size();
		int cartColCount = driver.findElements(By.xpath("(//table[@id='cart_info_table']//tr)[1]//td")).size();
		
//		System.out.println(cartRowCount);
//		System.out.println(cartColCount);
		
		for(int i = 1 ; i<=cartRowCount ; i++)
		{
		
			String cartData = driver.findElement(By.xpath("((//table[@id='cart_info_table']//tr)["+(i+1)+"]//a)[2]")).getText();
//			System.out.println(cartData);
		}
	}
	public String getProductNameInCart()
	{
		String productName = driver.findElement(By.xpath("(//td//h4)[1]")).getText();
		return productName;
	}
	
	public void clickOnProceedToCheckout()
	{
		proceedToCheckoutButton.click();
	}
	
	public void getCartInfo()
	{
//		List<WebElement> elementsInCart = driver.findElements(By.xpath("//div[@id='cart_info']"));
//		int sizeOfElementsInCart = elementsInCart.size();
//		System.out.println(sizeOfElementsInCart);
		
		
	}

}
