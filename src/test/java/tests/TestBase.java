package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void startDriver()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.navigate().to("https://www.phptravels.net/signup");
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException
	{
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshots/"+result.getName()+".png"));
			
			driver.quit();
		}
	}
	
	@AfterClass
	public void stopDriver()
	{
		driver.quit();
	}
	@AfterSuite
	public void generateReport() throws IOException
	{
		Runtime rt = Runtime.getRuntime();
		rt.exec("cmd.exe /c start allure serve \""+System.getProperty("user.dir")+"\\allure-results\"");
	}

}
