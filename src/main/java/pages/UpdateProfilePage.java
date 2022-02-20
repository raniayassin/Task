package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateProfilePage extends PageBase{

	public UpdateProfilePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "firstname")
	WebElement firstNameTxtBox;
	
	@FindBy(name = "lastname")
	WebElement lastNameTxtBox;
	
	@FindBy(name = "phone")
	WebElement phoneTxtBox;
	
	@FindBy(name = "email")
	WebElement emailTxtBox;
	
	@FindBy(name = "password")
	WebElement passwordTxtBox;
	
	@FindBy(name = "address1")
	WebElement addressTxtBox;
	
	@FindBy(css = "button.theme-btn.waves-effect")
	WebElement updateProfileBtn;
	
	@FindBy(css = "div.alert.alert-success")
	public WebElement successMsg;
	
	public String getFirstName()
	{
		return firstNameTxtBox.getAttribute("value");
	}
	public String getLastName()
	{
		return lastNameTxtBox.getAttribute("value");
	}
	public String getPhone()
	{
		return phoneTxtBox.getAttribute("value");
	}
	public String getEmail()
	{
		return emailTxtBox.getAttribute("value");
	}
	public void setAddress(String address)
	{
		sendText(addressTxtBox, address);
		addressTxtBox.sendKeys(Keys.ENTER);
	}
	public void clickOnUpdateProfileBtn()
	{
		updateProfileBtn.click();
	}

}
