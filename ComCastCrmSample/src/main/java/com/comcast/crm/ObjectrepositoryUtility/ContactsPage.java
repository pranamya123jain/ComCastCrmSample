package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;//global variable
	public ContactsPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	//this keyword refers OrganizationsPage class object
	}
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement creatContactLinkClick;
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement creatContactBtnClick;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdit;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement headerMsg;
	
	@FindBy(name = "support_start_date")
	private WebElement startDateEdit;
	
	@FindBy(name = "support_end_date")
	private WebElement endtDateEdit;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement actLastName;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement actStartDate;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement actEndDate;
	
	public WebElement getCreatContactLinkClick() {
		return creatContactLinkClick;
	}

	public WebElement getCreatContactBtnClick() {
		return creatContactBtnClick;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSelectOrgName() {
		return selectOrgName;
	}
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
 
	public WebElement getStartDateEdit() {
		return startDateEdit;
	}

	public WebElement getEndtDateEdit() {
		return endtDateEdit;
	}

	public WebElement getActLastName() {
		return actLastName;
	}

	
	public WebElement getActStartDate() {
		return actStartDate;
	}

	public WebElement getActEndDate() {
		return actEndDate;
	}

	public void creatContact(String lastName)
	{
		creatContactLinkClick.click();
		creatContactBtnClick.click();
		lastNameEdit.sendKeys(lastName);
		selectOrgName.click();	
	}
	public void creatContact(String startDate,String endDate)
	{
		startDateEdit.clear();
		startDateEdit.sendKeys(startDate);
		endtDateEdit.clear();
		endtDateEdit.sendKeys(endDate);
	}
}
