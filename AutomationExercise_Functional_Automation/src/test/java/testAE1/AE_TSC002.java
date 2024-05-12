package testAE1;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import packAE1.AccountCreatedPage;
import packAE1.CartPage;
import packAE1.CheckoutPage;
import packAE1.CreateAccountInfoPage;
import packAE1.HomePage;
import packAE1.PaymentPage;
import packAE1.SignupLoginPage;
import pom.modal.AddedToCartModule;
import pom.modal.CheckoutModule;

public class AE_TSC002 //******VERIFY ADD TO CART FUCNTIONALITY
{
	WebDriver driver;
	HomePage homePage;
	SignupLoginPage signuploginform ;
	AddedToCartModule addedToCartModal;
	CartPage cartPage;
	
	@BeforeClass
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//REFERENCE OF REQUIRED POM CLASSES
		homePage = new HomePage(driver);
		addedToCartModal = new AddedToCartModule(driver);
		cartPage = new CartPage(driver);
	}
	
//------------------------------------------------------------------------------	
	
	@BeforeMethod
	public void navigateMainURL()
	{
		driver.get("https://automationexercise.com/");
		
		//HOME PAGE VERIFICATION
		String homeTitle = homePage.homePageTitle();
		Assert.assertEquals(homeTitle, "Automation Exercise");
	}
	
//------------------------------------------------------------------------------
	
	@Test
												//AE_TC004
	public void addToCartRecommendedProducts()
	{
		homePage.scrollAndAddToCartRecommendedProduct();
		addedToCartModal.viewCart();
		
		String productNameInCart = cartPage.getProductNameInCart();
		assertEquals(productNameInCart, "Blue Top");
	}
	
	@Test
												//AE_TC005
	public void removeProductFromCart() throws InterruptedException
	{
		homePage.addToCartFirstProduct();
		addedToCartModal.viewCart();
		
		//CART PAGE VERIFICATION
		String cartPageURL = cartPage.cartPageGetURL();
		assertEquals(cartPageURL ,"https://automationexercise.com/view_cart");
		
		driver.findElement(By.xpath("//td//a[@class='cart_quantity_delete']")).click();
		
		Thread.sleep(3000);
		boolean isCartEmpty = driver.findElement(By.xpath("//div[@id='cart_info']//table")).isDisplayed();
		assertEquals(isCartEmpty, false);
	}
	
//------------------------------------------------------------------------------
	
	@AfterMethod
	public void deleteAccount() throws IOException
	{
		//GETTING SYSTEMS DATE & TIME
		LocalDateTime dateTime = LocalDateTime.now();
		String currDateTime = dateTime.toString().replace(":", "-");
		
		//TAKING SCREENSHOT
		TakesScreenshot takeSS = (TakesScreenshot) driver;
		File source = takeSS.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\Aniket\\OneDrive\\Desktop\\Velocity SW Testing Material\\Test ScreenShots\\Project_AutomationExercise\\Verify Add to cart functionality\\"+currDateTime+".png");
		FileHandler.copy(source, destination);
	}
	
//-------------------------------------------------------------------------------
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
