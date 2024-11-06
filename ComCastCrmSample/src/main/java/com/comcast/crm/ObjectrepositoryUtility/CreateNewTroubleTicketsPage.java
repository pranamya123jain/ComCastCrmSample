package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTroubleTicketsPage {

	WebDriver driver;

	public CreateNewTroubleTicketsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "ticket_title")
	private WebElement getTitleName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getGetTitleName() {
		return getTitleName;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void toCreateTicket(String title) {
		getTitleName.sendKeys(title);
		savebtn.click();

	}

}
