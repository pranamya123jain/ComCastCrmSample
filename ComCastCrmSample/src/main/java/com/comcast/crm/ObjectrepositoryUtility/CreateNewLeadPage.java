package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {

	WebDriver driver;
	public CreateNewLeadPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement getLastName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name="company")
	private WebElement getCompanyName;
	
	//getters
	public WebElement getGetLastName() {
		return getLastName;
	}

	public WebElement getGetCompanyName() {
		return getCompanyName;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void toCreateLead(String lastName, String company) {
		getLastName.sendKeys(lastName);
		getCompanyName.sendKeys(company);
		savebtn.click();
	}
}
