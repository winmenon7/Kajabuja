package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.io.Files;

public class Base {
	
	public static WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("//Users//vineethmenon//MavenJava//data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		String Url = prop.getProperty("Url");
		// While extracting a value from a property, we have to use [property.equals("value")]
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/vineethmenon/Downloads/chromedriver");
			driver = new ChromeDriver();
			
		}
		
		else if(browserName.equals("Firefox"))
		{
			//Code to invoke FF
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("Safari"))
		{
			//Code to invoke Safari
			driver = new SafariDriver();
		}
		
		//Script will wait for 10 seconds before it fails
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Url);
		
		return driver;
		
	}
	
	//Method for taking screenshots
	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		Files.copy(src, new File("/Users/vineethmenon/Desktop/ScreenshotSelenium/"+result+ " " + "screenshot.png"));
		
	}
	

}
