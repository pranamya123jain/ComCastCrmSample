package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleInformationPage {

	WebDriver driver;
	public TroubleInformationPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);	
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
}
