package com.crmcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webutility.WebDriverUtility;

public class ContactinfoPage
{
	WebDriverUtility wlib=new WebDriverUtility();
    WebDriver driver;
	public ContactinfoPage(WebDriver driver) 
	{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerTextVerify;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastNameVerify;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameVerify;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateVerify;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDateVerify;
	public WebDriverUtility getWlib() {
		return wlib;
	}

	public WebElement getHeaderTextVerify() {
		return headerTextVerify;
	}

	public WebElement getLastNameVerify() {
		return lastNameVerify;
	}

	public WebElement getOrgNameVerify() {
		return orgNameVerify;
	}

	public WebElement getStartDateVerify() {
		return startDateVerify;
	}

	public WebElement getEndDateVerify() {
		return endDateVerify;
	}
	
	
	
	
	
}
