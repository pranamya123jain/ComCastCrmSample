package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement getProductName;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebElement getGetProductName() {
		return getProductName;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void toCreateProduct(String productName) {
		getProductName.sendKeys(productName);
		savebtn.click();
	}


}
