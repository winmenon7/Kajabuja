package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Login Button in the home page
	By signIn = By.linkText("Login");
	
	@FindBy(linkText="Login")
	WebElement uSignIn;
	
	@FindBy(xpath="//*[contains(text(),'NO THANKS')]")
	WebElement popUp;
	
	@FindBy(xpath="//*[@class='container']/nav/ul/li[8]/a")
	WebElement Contact;
	
	public WebElement userSignIn()
	{
		return driver.findElement(signIn);
	}
	
	
	public WebElement signIn()
	{
		return uSignIn;
		
	}
	
	public WebElement contactDetails()
	{
		return Contact;
		
	}
	
	public WebElement popUp()
	{
		return popUp;
		
	}

}
