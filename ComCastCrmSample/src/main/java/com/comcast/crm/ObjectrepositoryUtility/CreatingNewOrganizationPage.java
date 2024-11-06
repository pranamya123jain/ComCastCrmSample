package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


public class CreatingNewOrganizationPage {
	WebDriver driver;//global variable
	public CreatingNewOrganizationPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="accountname")
	private WebElement orgNameEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn; 
	
	@FindBy(name ="industry")
	private WebElement industryDD;
	
	@FindBy(name ="accounttype")
	private WebElement typeDD;
	
	@FindBy(id ="phone")
	private WebElement phoneEdit;
	
	public WebElement getOrgName() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getPhoneEdit() {
		return phoneEdit;
	}

	public WebElement getType() {
		return typeDD;
	}
	
	
	//here i have to perform 2 action like entering org name and clicking save button
		//so i am creating business method
	public void creatOrg(String orgName)
	{
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();	
	}
	//method overloading method name is same argument is different
	public void creatOrg(String orgName, String pindustry)
	{
		orgNameEdit.sendKeys(orgName);
		WebDriverUtility w=new WebDriverUtility();
		w.select(industryDD, pindustry);
		
		saveBtn.click();
	}
	public void creatOrg(String orgName, String pindustry,String type)
	{
		orgNameEdit.sendKeys(orgName);
		WebDriverUtility w=new WebDriverUtility();
		w.select(pindustry,industryDD);
		w.select(type,typeDD);
		saveBtn.click();
	}
	public void creatOrg(String orgName, String pindustry,String type,String phoneNo)
	{
		orgNameEdit.sendKeys(orgName);
		WebDriverUtility w=new WebDriverUtility();
		w.select(pindustry,industryDD);
		w.select(type,typeDD);
		phoneEdit.sendKeys(phoneNo);
		saveBtn.click();
}}
