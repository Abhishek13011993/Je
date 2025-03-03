package com.crmcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	@FindBy(linkText = "Campaigns")
	private WebElement campaihnLink;
	@FindBy(linkText = "More")
	private WebElement moreLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getCampaihnLink() {
		return campaihnLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getAdminimg() {
		return adminimg;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	public void navigateToCampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaihnLink.click();
	}
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		signoutLink.click();
	}
}
