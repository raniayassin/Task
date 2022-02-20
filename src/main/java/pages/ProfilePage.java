package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase{

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "h4.author__title")
	public WebElement authorTitle;
	
	@FindBy(linkText = "My Profile")
	WebElement myProfileBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logoutBtn;
	
	public void clickOnMyProfileBtn()
	{
		myProfileBtn.click();
	}
	public void clickOnLogoutBtn()
	{
		logoutBtn.click();
	}

}
