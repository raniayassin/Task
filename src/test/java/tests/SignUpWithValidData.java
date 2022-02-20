package tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.ReadProperties;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SignupPage;
import pages.UpdateProfilePage;

public class SignUpWithValidData extends TestBase{

	SignupPage signupObject;
	LoginPage loginObject;
	ProfilePage profileObject;
	UpdateProfilePage updateProfileObject;

	String firstName = ReadProperties.data.getProperty("firstName");
	String lastName = ReadProperties.data.getProperty("lastName");
	String phone = ReadProperties.data.getProperty("phone");
	String email = ReadProperties.data.getProperty("email");
	String password = ReadProperties.data.getProperty("password");
	String accountType = ReadProperties.data.getProperty("accountType");
	String address = ReadProperties.data.getProperty("address");

	@Test(priority = 1)
	public void signup()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		signupObject = new SignupPage(driver);
		signupObject.clickOnGotItBtn();
		signupObject.setFirstName(firstName);
		signupObject.setLastName(lastName);
		signupObject.setPhone(phone);
		signupObject.setEmail(email);
		js.executeScript("window.scrollBy(0,350)", "");
		signupObject.setPassword(password);
		signupObject.selectAccountType(accountType);
		signupObject.clickOnSignupBtn();
		wait.until(ExpectedConditions.visibilityOf(signupObject.successMsg));
		Assert.assertTrue(signupObject.successMsg.getText().equalsIgnoreCase("Signup successfull please login."));
	}
	@Test(priority = 2, dependsOnMethods = "signup")
	public void login()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		loginObject = new LoginPage(driver);
		loginObject.setEmail(email);
		loginObject.setPassword(password);
		loginObject.clickOnLoginBtn();
		
		profileObject = new ProfilePage(driver);
		wait.until(ExpectedConditions.visibilityOf(profileObject.authorTitle));
		Assert.assertTrue(profileObject.authorTitle.getText().equalsIgnoreCase(firstName));
	}
	@Test(priority = 3, dependsOnMethods = "login")
	public void checkRegisteredUserData()
	{
		profileObject = new ProfilePage(driver);
		profileObject.clickOnMyProfileBtn();
		
		updateProfileObject = new UpdateProfilePage(driver);
		Assert.assertTrue(updateProfileObject.getFirstName().equalsIgnoreCase(firstName));
		Assert.assertTrue(updateProfileObject.getLastName().equalsIgnoreCase(lastName));
		Assert.assertTrue(updateProfileObject.getPhone().equalsIgnoreCase(phone));
		Assert.assertTrue(updateProfileObject.getEmail().equalsIgnoreCase(email));
	}
	
	@Test(priority = 4, dependsOnMethods = "checkRegisteredUserData")
	public void updateProfile()
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		updateProfileObject = new UpdateProfilePage(driver);
		updateProfileObject.setAddress(address);
		
		wait.until(ExpectedConditions.visibilityOf(updateProfileObject.successMsg));
		Assert.assertTrue(updateProfileObject.successMsg.getText().equalsIgnoreCase("Profile updated successfully."));
	}
	@Test(priority = 5, dependsOnMethods = "updateProfile")
	public void logout()
	{
		profileObject = new ProfilePage(driver);
		profileObject.clickOnLogoutBtn();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

}
