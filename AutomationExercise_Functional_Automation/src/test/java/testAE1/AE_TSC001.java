package testAE1;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public class AE_TSC001 //******VERIFY PLACE ORDER FUNCTIONALITY
{		
	WebDriver driver ;
	HomePage homePage;
	SignupLoginPage signuploginform ;
	AddedToCartModule addedToCartModal;
	CartPage cartPage;
	CheckoutModule checkoutModule;
	CreateAccountInfoPage createAccountInfoPage;
	AccountCreatedPage accCreatedPage;
	CheckoutPage checkoutPage;
	PaymentPage paymentPage;

	
		@BeforeClass
		public void launchBrowser()
		{
			
			//Ad Blocker section
//			ChromeOptions options = new ChromeOptions();
//			options.addExtensions(new File("C:\\Automation Libraries\\GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_5_22_0_0.crx"));
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//			options.merge(capabilities);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
//			System.setProperty("webdriver.chrome.driver","C:\\Automation Libraries\\chrome-win64\\chrome-win64\\chrome.exe");
			
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			
			
			//REFERENCE OF REQUIRED POM CLASSES
			homePage = new HomePage(driver);
			addedToCartModal = new AddedToCartModule(driver);
			cartPage = new CartPage(driver);
			checkoutModule = new CheckoutModule(driver);
			signuploginform = new SignupLoginPage(driver);
			createAccountInfoPage = new CreateAccountInfoPage(driver);
			accCreatedPage = new AccountCreatedPage(driver);
			checkoutPage = new CheckoutPage(driver);
			paymentPage = new PaymentPage(driver);
		}
		
//---------------------------------------------------------------------------------
		
		@BeforeMethod
		public void navigateURL()
		{
			driver.get("https://www.automationexercise.com");
			
			
			
			// HARD ASSERT - HOME PAGE VERIFICATION
			String homeTitle = homePage.homePageTitle();
			Assert.assertEquals(homeTitle, "Automation Exercise");
			
		}
		
//-----------------------------------------------------------------------------------
		//                               	 AE_TC001
		@Test
		public void registerWhilePlaceOrder()
		{
			//GETTING PRODUCT NAME ON HOME PAGE WHICH WE WANT TO ADD INTO THE CART
			String firstProductName = homePage.getFirstProductName();
			
			homePage.addToCartFirstProduct();
			addedToCartModal.clickOnContinueShopping();
			homePage.clickOnCart();
			
			//CART PAGE VERIFICATION
			String cartPageURL = cartPage.cartPageGetURL();
			assertEquals(cartPageURL ,"https://www.automationexercise.com/view_cart");
			System.out.println("CART PAGE VERIFIED!");
			
			//VERIFY PRODUCT NAME IN CART TO PRODUCT NAME ON HOME PAGE
			String productNameInCart = cartPage.getProductNameInCart();
			assertEquals(firstProductName, productNameInCart);
			System.out.println("PRODUCT IN CART PAGE VERIFIED!");
			
			cartPage.clickOnProceedToCheckout();
			checkoutModule.clickOnRegisterOrLoginButton();
			
			//SIGN UP FORM VERIFICATION
			boolean signUpFormVerification = signuploginform.isSignUpFormVisible();
			Assert.assertEquals(signUpFormVerification, true);
			System.out.println("SIGN UP FORM VERIFIED!");
			
			signuploginform.signUpProcess("Aniket Chorghe", "ac9797@gmail.com");
			
			String uNameOnAccPage = createAccountInfoPage.userNameOnAccountPage();
			
			createAccountInfoPage.createAccount();
			accCreatedPage.accountCreatedMsgVerification();
			accCreatedPage.clickOnContinueButton();
			
			//VERIFY USERNAME ON HOME PAGE
			String uNameOnHomePage = homePage.getUserNameOnHomePage();
			Assert.assertEquals(uNameOnHomePage ,uNameOnAccPage, "Username is not Verified!");
			System.out.println("LOGGED IN AS USERNAME VERIFIED!");
			
			homePage.clickOnCart();
			
			//COMMON STEPS FOR THIS SCENARIO
			cartPage.clickOnProceedToCheckout();
			checkoutPage.addCommentInTheBox();
			paymentPage.submitPaymentDetails();	

		}
		
		//                                      AE_TC002
		@Test
		public void registerFirstAndPlaceOrder()
		{
			
			homePage.clickOnSignUp();
			
			//HARD ASSERT - SIGN UP FORM VERIFICATION
			boolean signUpFormVerification = signuploginform.isSignUpFormVisible();
			Assert.assertEquals(signUpFormVerification, true);
			
			signuploginform.signUpProcess("Aniket Chorghe", "ac9797@gmail.com");
			
			String uNameOnAccPage = createAccountInfoPage.userNameOnAccountPage();
			
			createAccountInfoPage.createAccount();
			accCreatedPage.accountCreatedMsgVerification();
			accCreatedPage.clickOnContinueButton();
			
			//Hard Assert
			String uNameOnHomePage = homePage.getUserNameOnHomePage();
			Assert.assertEquals(uNameOnHomePage ,uNameOnAccPage, "Username is not Verified!");
									
			homePage.addToCartFirstProduct();
			addedToCartModal.clickOnContinueShopping();
			homePage.clickOnCart();
			
			//HARD ASSERT - CART PAGE VERIFICATION
			String cartPageURL = cartPage.cartPageGetURL();
			Assert.assertEquals(cartPageURL ,"https://www.automationexercise.com/view_cart");
			
			
			//COMMON STEPS FOR THIS SCENARIO
			cartPage.clickOnProceedToCheckout();
			checkoutPage.addCommentInTheBox();
			paymentPage.submitPaymentDetails();	
		
		}
		
		
		//                                 AE_TC003
		@Test
		public void loginAndPlaceOrder()
		{
			
			homePage.clickOnSignUp();
			
			//HARD ASSERT - SIGN UP FORM VERIFICATION
			boolean signUpFormVerification = signuploginform.isSignUpFormVisible();
			Assert.assertEquals(signUpFormVerification, true);
			
			signuploginform.signUpProcess("Aniket Chorghe", "ac9797@gmail.com");
			
			String uNameOnAccPage = createAccountInfoPage.userNameOnAccountPage();
						
			createAccountInfoPage.createAccount();
			accCreatedPage.accountCreatedMsgVerification();
			accCreatedPage.clickOnContinueButton();
			homePage.logOutProcess();
			signuploginform.loginFormVerification();
			signuploginform.loginProcess();
			
			//HARD ASSERT - USER NAME VERIFICATION
			String uNameOnHomePage = homePage.getUserNameOnHomePage();
			Assert.assertEquals(uNameOnHomePage ,uNameOnAccPage, "Username is not Verified!");
						
			homePage.addToCartFirstProduct();
			addedToCartModal.clickOnContinueShopping();
			homePage.clickOnCart();
			
			//HARD ASSERT - CART PAGE VERIFICATION
			String cartPageURL = cartPage.cartPageGetURL();
			Assert.assertEquals(cartPageURL ,"https://www.automationexercise.com/view_cart");
			
			
			//COMMON STEPS FOR THIS SCENARIO
			cartPage.clickOnProceedToCheckout();
			checkoutPage.addCommentInTheBox();
			paymentPage.submitPaymentDetails();	
			
			
		}
		
//--------------------------------------------------------------------------------------
		
		@AfterMethod
		public void takeSSAnsDeleteAccount() throws IOException	
		{
			//GETTING SYSTEMS DATE & TIME
			LocalDateTime dateTime = LocalDateTime.now();
			String currDateTime = dateTime.toString().replace(":", "-");
			
			//TAKING SCREENSHOT
			TakesScreenshot takeSS = (TakesScreenshot) driver;
			File source = takeSS.getScreenshotAs(OutputType.FILE);
			File destination = new File("C:\\Users\\Aniket\\OneDrive\\Desktop\\Velocity SW Testing Material\\Test ScreenShots\\Project_AutomationExercise\\Verify Place Order Functionality\\"+currDateTime+".png");
			FileHandler.copy(source, destination);
			
			homePage.deleteAccountVerification();
		}
	
//---------------------------------------------------------------------------------------
		
		@AfterClass
		public void closeBrowser()
		{
			driver.close();
		}

		
	}


