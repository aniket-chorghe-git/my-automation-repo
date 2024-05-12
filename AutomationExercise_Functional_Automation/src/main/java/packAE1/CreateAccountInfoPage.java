package packAE1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountInfoPage {
	
	WebDriver driver ;
	Select selectFromList;
	
	@FindBy (xpath = "//input[@id='id_gender1']")
	private WebElement titleRadioButton;
	
	@FindBy (xpath = "//input[@id='name']")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@id='password']")
	private WebElement passwordInputField;
	
	@FindBy (xpath = "//select[@id='days']")
	private WebElement dayDropdown;
	
	@FindBy (xpath = "//select[@id='months']")
	private WebElement monthDropdown;
	
	@FindBy (xpath = "//select[@id='years']")
	private WebElement yearDropdown;
	
	@FindBy (xpath = "//input[@id='first_name']")
	private WebElement firstNameField;
	
	@FindBy (xpath = "//input[@id='last_name']")
	private WebElement lastNameField;
	
	@FindBy (xpath = "//input[@id='company']")
	private WebElement companyField;
	
	@FindBy (xpath = "//input[@id='address1']")
	private WebElement requiredAddressField;
	
	@FindBy (xpath = "//input[@id='state']")
	private WebElement stateField;
	
	@FindBy (xpath = "//input[@id='city']")
	private WebElement cityField;
	
	@FindBy (xpath = "//input[@id='zipcode']")
	private WebElement zipcodeField;
	
	@FindBy (xpath = "//input[@id='mobile_number']")
	private WebElement mobileNumberField;
	
	@FindBy (xpath = "//button[text()='Create Account']")
	private WebElement createAccountButton;


	//Constructor - public only
	public CreateAccountInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods - Public only
	
	public String userNameOnAccountPage()
	{
		String AccountUserName = userName.getAttribute("value");
		return AccountUserName;
	}
	
	public void createAccount()
	{
		titleRadioButton.click();
		
		passwordInputField.sendKeys("ac@9797");		
		
		selectFromList = new Select(dayDropdown);
		selectFromList.selectByValue("9");
		
		selectFromList = new Select(monthDropdown);
		selectFromList.selectByValue("7");
		
		selectFromList = new Select(yearDropdown);
		selectFromList.selectByValue("1997");
		
		firstNameField.sendKeys("Aniket");
		lastNameField.sendKeys("Chorghe");
		companyField.sendKeys("xyz bank pvt ltd");
		requiredAddressField.sendKeys("flat no. 1, Gururaj society, karve road");
		stateField.sendKeys("Maharashtra");
		cityField.sendKeys("Pune");
		zipcodeField.sendKeys("411023");
		mobileNumberField.sendKeys("9898989898");
	
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)",createAccountButton);
		createAccountButton.click();
		

	}

}
