package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement password; 
	@FindBy(xpath="//input[@id='input-confirm']") WebElement conpassword;
	@FindBy(xpath="//label[normalize-space()='Yes']//input[@name='newsletter']") WebElement newsletterbox;
	@FindBy(xpath="//input[@name='agree']") WebElement agreebox;
	@FindBy(xpath="//input[@value='Continue']") WebElement continuebtn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmMsg;
	 
	public void setfirstname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setlastname(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void setemail(String mail) {
		email.sendKeys(mail);
	}
	
	public void settelephone(String phone) {
		telephone.sendKeys(phone);	
	}
	
	public void setpassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void setconfirmpassword(String conpass) {
		conpassword.sendKeys(conpass);
	}
	
	public void checknewsbox() {
		newsletterbox.click();
		
	}
	
	public void checkagreebox() {
		agreebox.click();
	}
	
	public void clickcontinue() {
		continuebtn.click();
	}

// look for it on chat gpt later 
	public String getConfirmMessage() {
		try {
			return(confirmMsg.getText());
		}
		catch (Exception e) {
			return(e.getMessage());
			
		}
	}


	

}
