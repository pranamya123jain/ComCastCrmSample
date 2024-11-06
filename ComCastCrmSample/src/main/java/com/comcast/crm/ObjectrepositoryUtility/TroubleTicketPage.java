package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {

	WebDriver driver;
	public TroubleTicketPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Ticket...']")
	private WebElement createTroubleLink;
	
	public WebElement getCreateTroubleLink() {
		return createTroubleLink;
	}
		
}

