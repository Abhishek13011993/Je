package com.crmcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webutility.WebDriverUtility;

public class LoginPage {
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;                                                              
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;    
	}
	public void loginToapp(String Url,String username,String password) {
		driver.get(Url);
		wlib.waitForPageToLoad(driver);

		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
