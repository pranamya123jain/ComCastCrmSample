package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
		WebDriver driver;
		public CreateNewCampaignPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(name = "campaignname")
		private WebElement campaignNameEdit;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		public WebElement getCampaignNameEdit() {
			return campaignNameEdit;	
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		public void toCreateCampaign(String campaignName)
		{
			campaignNameEdit.sendKeys(campaignName);
			saveBtn.click();
		}
		
}
