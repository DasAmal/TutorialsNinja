package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage {
	
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement AccountMsg;

	public String getLoginMessage() {
		
		try {
			return(AccountMsg.getText());
		}
		catch (Exception e) {
			return(e.getMessage());
	}
		
}
}
