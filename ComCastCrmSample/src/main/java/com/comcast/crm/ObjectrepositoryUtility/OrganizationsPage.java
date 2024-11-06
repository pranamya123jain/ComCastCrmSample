package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	WebDriver driver;//global variable
	public OrganizationsPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	//this keyword refers OrganizationsPage class object
	}
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchFor;
		
	@FindBy(name="search_field")
	private WebElement organizationDD;
	
	@FindBy(name="submit")
	private WebElement searchNow;
	
	//Getters
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getSearchFor() {
		return searchFor;
	}

	public WebElement getOrganizationDD() {
		return organizationDD;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}
	
	
	//no need to write business method
	
}
