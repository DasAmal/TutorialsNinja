package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	 WebDriver driver;
	// Constructor to initialize elements
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  // Initialize all @FindBy elements

}
	    @FindBy(xpath="//span[@class='caret']")
	    WebElement lnk_myaccount;
	    
	    @FindBy(xpath="//a[normalize-space()='Register']")
	    WebElement lnk_register;
	    
	    @FindBy(xpath="//a[normalize-space()='Login']")
	    WebElement lnk_login;
	    
        public void clickmyaccount() {
        	lnk_myaccount.click();
        }
        
        public void clickregister() {
        	lnk_register.click();
        }
	    
        public void clicklogin() {
        	lnk_login.click();
        }
	
}



