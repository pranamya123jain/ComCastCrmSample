package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	WebDriver driver;//global variable
	public OpportunitiesPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	//this keyword refers OrganizationsPage class object
	}
	
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement creatNewOpportunityBtn;
	
	public WebElement getCreatNewOpportunityBtn() {
		return creatNewOpportunityBtn;
	}
	
	
}
