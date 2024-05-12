package packAE1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	private WebDriver driver;
	
	//Variables - Private only
	@FindBy (xpath = "//a[text()=' Signup / Login']") private WebElement signUpButton;
	@FindBy (xpath = "(//div[@class='productinfo text-center']//a[text()='Add to cart'])[1]") private WebElement addToCartButtonForProductOne;
	@FindBy (xpath = "//a[text()=' Cart']") private WebElement cartButtonOnHomePage;
	@FindBy (xpath = "//ul[@class='nav navbar-nav']//li//b") private WebElement loggedInAsButton;
	@FindBy (xpath = "//a[text()=' Delete Account']") private WebElement deleteAccountButton;
	@FindBy (xpath = "//b[text()='Account Deleted!']") private WebElement deleteAccSuccessMsg;
	@FindBy (xpath = "//a[text()=' Logout']") private WebElement logOutButton;
	@FindBy (xpath = "//div[@class='recommended_items']") private WebElement recommendedProductsList;
	@FindBy (xpath = "((//div[@class='carousel-inner'])[2]//a[text()='Add to cart'])[1]") private WebElement recommendedProductAddToCartButton;
	
	
	//Constructor - public only
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods - Public only
	public String homePageTitle()
	{
		String HomePageTitle = driver.getTitle();
		return HomePageTitle;
	
	}
	public String getFirstProductName()
	{
		String pName = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]//p")).getText();
		return pName;
	}
	public String getUserNameOnHomePage()
	{
		String userNameOnHomePage = loggedInAsButton.getText();
		return userNameOnHomePage;
	}
	public void logOutProcess()
	{
		if(logOutButton.isDisplayed()==true)
		{
			logOutButton.click();
		}
		else
		{
			System.out.println("Logout button is not visible");
		}	
	}
	public void addToCartFirstProduct()
	{

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)",addToCartButtonForProductOne);
		
		
		
		addToCartButtonForProductOne.click();
		
		
	}
	
	public void scrollAndAddToCartRecommendedProduct()
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)",recommendedProductsList);
		
		recommendedProductAddToCartButton.click();		
	}
	
	public void clickOnSignUp()
	{
		signUpButton.click();
	}
	
	public void clickOnCart()
	{
		cartButtonOnHomePage.click();
	}
	
	public void deleteAccountVerification()
	{
		deleteAccountButton.click();
		
		
		boolean deleteAccText = deleteAccSuccessMsg.isDisplayed();
		Assert.assertEquals(deleteAccText, true, "Account has been deleted");
		
	}
	
	

}
