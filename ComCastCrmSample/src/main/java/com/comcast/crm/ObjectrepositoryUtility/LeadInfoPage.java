package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	
	WebDriver driver;
	public LeadInfoPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);	
	}
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;

}

