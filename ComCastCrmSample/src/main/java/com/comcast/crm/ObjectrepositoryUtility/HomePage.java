
package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {

	WebDriver driver;//global veritable
	public HomePage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	//this keyword refers current class object
	}
	
	@FindBy(partialLinkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunityLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img [@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTicketsLink;
	
	@FindBy(name="Service Contracts")
	private WebElement serviceContractsLink;
	
	@FindBy(linkText="Calendar")
	private WebElement calenderLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getOpportunityLink() {
		return opportunityLink;
	}
	
	public WebElement getleadLink() {
		return leadLink;
	}
	
	public WebElement getproductsLink() {
		return productsLink;
	}
	
	public WebElement gettroubleTicketsLink() {
		return troubleTicketsLink;
	}
	
	public WebElement getServiceContractsLink() {
		return serviceContractsLink;
	}
	
	//create business library
	public void navigateToCampaignspage()
	{
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.moveOnElement(driver, moreLink);
		campaignsLink.click();
	}
	public void logout()
	{
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.moveOnElement(driver, adminimg);
		signOutLink.click();
	}
	public void navigatetoserviceContractsPage() {
		Actions act=new Actions(driver);
		act.moveToElement(serviceContractsLink).perform();
		serviceContractsLink.click();
}
	public void navigatetoMore() {
		Actions action= new Actions(driver);
		action.moveToElement(moreLink).perform();	
	}	
	public void navigatetoCampaigns() {
		Actions action= new Actions(driver);
		action.moveToElement(moreLink).perform();
}
}