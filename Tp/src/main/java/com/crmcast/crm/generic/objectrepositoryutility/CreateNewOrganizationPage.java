package com.crmcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(name="industry")
	private WebElement industryDB;
	@FindBy(name="accounttype")
	private WebElement typeDB;
	@FindBy(id="phone")
	private WebElement phoneedit;
	
	public WebElement getPhoneedit() {
		return phoneedit;
	}
	public WebElement getIndustryDB() {
		return industryDB;
	}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getTypeDB() {
		return typeDB;
	}
	public void createorg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createorg(String orgName,String industry,String type) {
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(industryDB);
		sel.selectByVisibleText(industry);
		sel.selectByVisibleText(type);
		saveBtn.click();
	}
	
	
}
