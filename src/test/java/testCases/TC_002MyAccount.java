package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002MyAccount extends BaseClass {
	
	
	@Test(groups="sanity")
	public void verify_Account_login() {
		
		try {
			    logger.info("****Starting TestCase_002");
				HomePage hp = new HomePage(driver);
				
				logger.info("****Clicked on MyAccount****");
				hp.clickmyaccount();
				
				logger.info("****Clicked on Login****");
				hp.clicklogin();
				
				
				LoginPage lp = new LoginPage(driver);
				
				logger.info("***Providing Details***");
				
				lp.setusername("amaldas4@gmail.com");
				lp.setpassword("amal123");
				
				logger.info("****Clicked on Login****");
				lp.clicklogin();
		
				MyAccountPage ap = new MyAccountPage(driver);
				
				String acmsg = ap.getLoginMessage();
				if (acmsg.equals("My Account")) {
				    System.out.println("✅ Login successful – 'My Account' is visible on the page.");
				} else {
				    System.out.println("❌ Login failed – 'My Account' text not found.");
				}

				Assert.assertEquals(acmsg, "My Account");
	}
		catch(Exception e) {
			Assert.fail();
			
		}
}
}