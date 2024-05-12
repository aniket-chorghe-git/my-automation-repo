package packAE1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupLoginPage {
	
	
	@FindBy (xpath = "//div[@class='signup-form']")
	private WebElement signUpForm;
	
	@FindBy (xpath = "//input[@data-qa='signup-name']")
	private WebElement nameField;
	
	@FindBy (xpath = "//input[@data-qa='signup-email']")
	private WebElement emailField;
	
	@FindBy (xpath = "//button[text()='Signup']")
	private WebElement signUpButton;
	
	@FindBy (xpath = "//div[@class='login-form']")
	private WebElement loginForm;
	
	@FindBy (xpath = "(//input[@type='email'])[1]")
	private WebElement loginEmailField;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement loginPasswordField;
	
	@FindBy (xpath = "//button[text()='Login']")
	private WebElement loginSubmitButton;
	
	@FindBy (xpath = "//p[text()='Email Address already exist!']")
	private WebElement accountAlreadyExistMsg;
	
	
	//Constructor - public only
		public SignupLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		
		//Methods - Public only
		
		public void loginFormVerification()
		{
			if(loginForm.isDisplayed()==true)
			{
				System.out.println("Login form is visible");
			}
			else
			{
				System.out.println("Login form is not visible");
			}
			
		}
		
		public void loginProcess()
		{
			loginEmailField.sendKeys("ac9797@gmail.com");
			loginPasswordField.sendKeys("ac@9797");
			loginSubmitButton.click();
		}
		
		public boolean isSignUpFormVisible()
		{
			boolean formVisibility = signUpForm.isDisplayed();
			return formVisibility;
		}
		
		public void signUpProcess(String nameInput, String emailInput)
		{
			nameField.sendKeys(nameInput);
			emailField.sendKeys(emailInput);
			signUpButton.click();
		}
		

		
}
