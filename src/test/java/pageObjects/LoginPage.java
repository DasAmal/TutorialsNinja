package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement lpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	
	public void setusername(String uname) {
		email.sendKeys(uname);
		
	}
	
	public void setpassword(String password) {
		lpassword.sendKeys(password);
		
	}
	
	public void clicklogin() {
		loginbtn.click();
	}

}
