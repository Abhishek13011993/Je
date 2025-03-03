package com.crmcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdit;
	
	@FindBy(name="support_end_date")
	private WebElement endDateEdit;
	
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement attachOrgBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveContactBtn;
	
	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getStartDateEdit() {
		return startDateEdit;
	}

	public WebElement getEndDateEdit() {
		return endDateEdit;
	}

	
	public WebElement getAttachOrgBtn() {
		return attachOrgBtn;
	}

	public WebElement getSaveContactBtn() {
		return saveContactBtn;
	}
	
	
	
}
