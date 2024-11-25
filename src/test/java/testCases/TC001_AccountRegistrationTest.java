package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {
		logger.info("****Starting TC001_AccountRegistrationTest****");
		
		try {
			HomePage hp=new HomePage(driver);
			Thread.sleep(10);
			hp.clickMyAccount();
			logger.info("****Clicked on MyAccount****");
			hp.clickRegister();
			logger.info("****Clicked on Register****");
			
			AccountRegistrationsPage regpage=new AccountRegistrationsPage(driver);
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString()+"@gmail.com");
			regpage.setTelephone(randomNumber());
			
			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.clickToggle();
			regpage.clickContinue();
			
			//Validation
			String confmsg=regpage.getConfirmMessage();
			
			if(confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test Failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	
}
