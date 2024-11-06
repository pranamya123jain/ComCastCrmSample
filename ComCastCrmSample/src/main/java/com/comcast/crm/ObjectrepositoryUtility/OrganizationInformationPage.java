package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationInformationPage {
	WebDriver driver;//global variable
	public OrganizationInformationPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id = "mouseArea_Industry")
	private WebElement industryDD;
	
	@FindBy(id = "mouseArea_Type")
	private WebElement typeDD;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneNoInfo;
	
	public WebElement getPhoneNoInfo() {
		return phoneNoInfo;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}
	
	
	
	
}
