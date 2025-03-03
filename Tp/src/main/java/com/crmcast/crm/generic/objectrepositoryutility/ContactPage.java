package com.crmcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//img[@title='Create Contact...']")
	private WebElement createcntbtn;
	
		public WebElement getCreatecntbtn() {
		return createcntbtn;
}

}
