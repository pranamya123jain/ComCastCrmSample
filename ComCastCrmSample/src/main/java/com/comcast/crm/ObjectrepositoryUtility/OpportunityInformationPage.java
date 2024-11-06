package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	WebDriver driver;//global variable
	public OpportunityInformationPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	//this keyword refers OrganizationsPage class object
	}

@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement headerMsg;

public WebElement getHeaderMsg() {
	return headerMsg;
}


	
	
		

	
	
}
