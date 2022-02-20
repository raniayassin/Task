package tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.ReadProperties;
import pages.SignupPage;

public class SignupWithLastNameSameAsFirstName extends TestBase{
	
	SignupPage signupObject;

	String firstName = ReadProperties.data.getProperty("firstName");
	String lastName = ReadProperties.data.getProperty("lastName");
	String phone = ReadProperties.data.getProperty("phone");
	String email = ReadProperties.data.getProperty("email");
	String password = ReadProperties.data.getProperty("password");
	String accountType = ReadProperties.data.getProperty("accountType");
	String address = ReadProperties.data.getProperty("address");

	@Test(priority = 1)
	public void signupWithLastNameSameAsFirstName()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		signupObject = new SignupPage(driver);
		signupObject.clickOnGotItBtn();
		
		// Last name same as first name
		signupObject.setFirstName(firstName);
		signupObject.setLastName(firstName);
		signupObject.setPhone(phone);
		signupObject.setEmail("b"+email);
		js.executeScript("window.scrollBy(0,350)", "");
		signupObject.setPassword(password);
		signupObject.selectAccountType(accountType);
		signupObject.clickOnSignupBtn();
		wait.until(ExpectedConditions.visibilityOf(signupObject.successMsg));
		Assert.assertFalse(signupObject.successMsg.getText().contains("successfull"));
	}

}
