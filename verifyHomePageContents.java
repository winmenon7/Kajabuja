package Academy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectRepository.HomePage;
import resources.Base;

public class verifyHomePageContents extends Base  {
	
	@BeforeTest
	public void launchUrl() throws IOException
	{
		driver = initializeDriver();	
	}
	
	@Test
	public void verifyContents() throws IOException
	{
		driver = initializeDriver();
		//driver.get("http://qaclickacademy.com");
		HomePage hp = new HomePage(driver);
		
		if(hp.popUp().isDisplayed())
		{
			hp.popUp().click();
			AssertJUnit.assertTrue(hp.contactDetails().isDisplayed());
		}
		else
		AssertJUnit.assertTrue(hp.contactDetails().isDisplayed());
		AssertJUnit.assertEquals(hp.contactDetails().getText(), "CONTACT");
		
		hp.contactDetails().click();
				
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		driver =null;
	}

}
