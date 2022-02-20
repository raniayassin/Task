package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "email")
	WebElement emailTxtBox;
	
	@FindBy(name = "password")
	WebElement passwordTxtBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg.btn-block.effect.ladda-button.waves-effect")
	WebElement loginBtn;

	public void setEmail(String email)
	{
		sendText(emailTxtBox, email);
	}
	public void setPassword(String password)
	{
		sendText(passwordTxtBox, password);
	}
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
}
