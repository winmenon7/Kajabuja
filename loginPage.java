package pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;
	public  loginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//User Id
	@FindBy(id="user_email")
	WebElement userId;
	
	//Passowrd
	@FindBy(id="user_password")
	WebElement userPassword;
	
	
	//SignIn button
	@FindBy(name="commit")
	WebElement clickLogin;
	
	//Login error message
	@FindBy(xpath="//*[contains(text(),'Invalid')]")
	WebElement loginError;
	
	//To enter user id
	public WebElement userId()
	{
		return userId;
	}
	
	//To enter password
		public WebElement userPassword()
		{
			return userPassword;
		}
		
	//To submit the login
		public WebElement userLogin()
		{
			return clickLogin;
		}
		
	//To validate error message on login
		public WebElement loginError()
		{
			return loginError;
		}
		
		
}
