package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	WebDriver driver;
	public  CampaignInfoPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private	WebElement headerMsg;
	
	@FindBy(id = "dtlview_Campaign Name")
	private WebElement campaignNameInfo;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public WebElement getCampaignNameInfo() {
		return campaignNameInfo;
	}
	
	
}
