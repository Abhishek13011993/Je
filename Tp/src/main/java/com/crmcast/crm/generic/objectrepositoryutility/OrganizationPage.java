package com.crmcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search_field")
	private WebElement searchDB;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createnewBtn;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
    public WebElement getSearchDB() {
		return searchDB;
	}
    public WebElement getCreatenewBtn() {
		return createnewBtn;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
