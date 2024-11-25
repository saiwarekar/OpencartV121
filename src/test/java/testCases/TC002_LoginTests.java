package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTests extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_login() throws IOException {
		logger.info("****Starting TC002_LoginTests****");
		
		
//		FileReader file=new FileReader("./src//test//resources//config.properties");
//		Properties p = new Properties();
//		p.load(file);
		
		try {
			//Home Page
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login page
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//MyAccounnt page
			MyAccountPage myacc=new MyAccountPage(driver);
			boolean targetPage=myacc.isMyAccountPageExists();
			
			Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****Ending TC002_LogionTests****");
	}
	
}
