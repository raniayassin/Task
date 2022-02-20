package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends PageBase{
	
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "first_name")
	WebElement firstNameTxtBox;
	
	@FindBy(name = "last_name")
	WebElement lastNameTxtBox;
	
	@FindBy(name = "phone")
	WebElement phoneTxtBox;
	
	@FindBy(name = "email")
	WebElement emailTxtBox;
	
	@FindBy(name = "password")
	WebElement passwordTxtBox;
	
	@FindBy(css = "span.select2-selection.select2-selection--single")
	WebElement accountTypeBtn;
	
	@FindBy(id = "select2-account_type-results")
	WebElement accountTypeList;
	
	@FindBy(css = "button.btn.btn-default.btn-lg.btn-block.effect.ladda-button.waves-effect")
	WebElement signupBtn;
	
	@FindBy(id = "cookie_stop")
	WebElement gotItBtn;
	
	@FindBy(css = "div.message")
	public WebElement successMsg;
	
	public void setFirstName(String firstName)
	{
		sendText(firstNameTxtBox, firstName);
	}
	public void setLastName(String lastName)
	{
		sendText(lastNameTxtBox, lastName);
	}
	public void setPhone(String phone)
	{
		sendText(phoneTxtBox, phone);
	}
	public void setEmail(String email)
	{
		sendText(emailTxtBox, email);
	}
	public void setPassword(String password)
	{
		sendText(passwordTxtBox, password);
	}
	public void selectAccountType(String accountType)
	{
		accountTypeBtn.click();
		selectFromList(accountTypeList, accountType, "li");
	}
	public void clickOnGotItBtn()
	{
		gotItBtn.click();
	}
	public void clickOnSignupBtn()
	{
		signupBtn.click();
	}

}
