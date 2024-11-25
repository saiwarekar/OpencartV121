package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationsPage extends BasePage {
	
	WebDriver driver;
	
	public AccountRegistrationsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@name='agree']") WebElement txtToggle;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//div[@id='content']/h1") WebElement msgConfirm;
	
	//Your Account Has Been Created!
	//https://demo.opencart.com/
//	driver.get("https://demo.opencart.com/");
	
	public void setFirstName(String name) {
		txtFirstName.sendKeys(name);
	}
	
	public void setLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String confPassword) {
		txtConfirmPassword.sendKeys(confPassword);
	}
	
	public void setTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}
	
	public void clickToggle() {
		txtToggle.click();
	}
	
	public void clickContinue() {
		btnContinue.click(); //If not worked then try other ways: Javascript executer, using actions or etc.
	}
	
	public String getConfirmMessage() {
		try {
			return (msgConfirm.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	
}
