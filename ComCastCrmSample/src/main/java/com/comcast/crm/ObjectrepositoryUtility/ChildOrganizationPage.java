package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildOrganizationPage {

	WebDriver driver;//global variable
	public ChildOrganizationPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	//this keyword refers OrganizationsPage class object
	}
	@FindBy(id = "search_txt")
	private WebElement SearchEdit;
	
	@FindBy(xpath = "//input[@class='crmbutton small create']")
	private WebElement SearchNowClick;
	

	
	public WebElement getSearchEdit() {
		return SearchEdit;
	}

	public WebElement getSearchNowClick() {
		return SearchNowClick;
	}

	
	//business library
	public void creatChildOrg(String orgName)
	{
		SearchEdit.sendKeys(orgName);
		SearchNowClick.click();
		
	}
	
}
