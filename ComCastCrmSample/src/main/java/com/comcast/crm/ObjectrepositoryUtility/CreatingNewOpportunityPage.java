package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOpportunityPage {
	WebDriver driver;//global variable
	public CreatingNewOpportunityPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	//this keyword refers OrganizationsPage class object
	}

	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement opportunityNameEdit;
	
	@FindBy(xpath = "//input[@name='related_to_display']/../img")
	private WebElement selectOrganization;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOpportunityNameEdit() {
		return opportunityNameEdit;
	}

	public WebElement getSelectOrganization() {
		return selectOrganization;
	}
	
	public void creatOpportunity(String oppName)
	{
		opportunityNameEdit.sendKeys(oppName);
		selectOrganization.click();
			
	}
		
	
}
