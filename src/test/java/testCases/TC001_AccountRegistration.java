package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC001_AccountRegistration extends BaseClass {
	
	@Test(groups="regression")
	public void verify_account_registration() {
		
		try {
			
			
		logger.info("****Starting TestCase_001");
		HomePage hp = new HomePage(driver);
		
		hp.clickmyaccount();
		//clicked on myaccount
		logger.info("****Clicked on MyAccount****");
		hp.clickregister();
		logger.info("****Clicked on Register****");
		//clicked on register
		
		RegisterPage rp = new RegisterPage(driver);
		
		logger.info("***Providing Details***");
		
		rp.setfirstname("Amal");
		rp.setlastname("Das");
		
		//To get random email. using apache common lang mvn repo
		rp.setemail(randomName()+"@gmail.com");
		
		rp.settelephone("9496753917");
		rp.setpassword("amal123");
		rp.setconfirmpassword("amal133");
		rp.checkagreebox();
		rp.checknewsbox();
		rp.clickcontinue();
		logger.info("****Clicked on Continue****");
		
		//to check the registration successful message is passed.
		
		String cmsg = rp.getConfirmMessage();
		Assert.assertEquals(cmsg, "Your Account Has Been Created!");
		//Loggin info(Checking assertation)
		}
	
        catch(Exception e) {
        	Assert.fail();
        }
	
	}
	

}
	

	

