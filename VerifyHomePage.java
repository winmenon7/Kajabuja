package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepository.HomePage;
import pageObjectRepository.loginPage;
import resources.Base;

public class VerifyHomePage extends Base {
	
	//Implementing Log4j2
	Logger log = LogManager.getLogger(VerifyHomePage.class.getName());

	@BeforeTest
	public void launchUrl() throws IOException
	{
		driver = initializeDriver();	
		log.info("Driver is initialized and browser is launched");
	}
	
	@Test(dataProvider="getData")
	public void homePageNavigation(String userName, String Pwd) throws IOException
	{
		// Calling the re-usable method where browser details are already passed
		
		
		//driver.get("http://qaclickacademy.com");
		
		HomePage hp = new HomePage(driver);
		
		//Create an object for the LoginPage
		loginPage lp = new loginPage(driver);
		
		if(hp.popUp().isDisplayed())
		{
			hp.popUp().click();
			//hp.userSignIn().click();
			hp.signIn().click();
			
			lp.userId().sendKeys(userName);
			lp.userPassword().sendKeys(Pwd);
			lp.userLogin().click();
			
		}
		else
		//hp.userSignIn().click();
		hp.signIn().click();
				
		lp.userId().sendKeys(userName);
		lp.userPassword().sendKeys(Pwd);
		lp.userLogin().click();
		
		System.out.println(lp.loginError().getText());
		
		//Assert.assertEquals(lp.loginError().getText(), "Invalid email or passwords");
		
		/*if(lp.loginError().getText().equals("Invalid email or password"))
			{System.out.println("Test case is pass");
	}else System.out.println("Test case failed"); */
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		driver =null;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "vineeth@abc.com";
		data[0][1] = "passwordone";
		//data[1][0] = "menon@abc.com";
		//data[1][1] = "passwordtwo";

		return data;
		
	}
	
	
}
