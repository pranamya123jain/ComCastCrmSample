package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateServiceContractPage {

	
		WebDriver driver;
		public CreateServiceContractPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="subject")
		private WebElement subjectEdit;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement savebtn;
		
		public WebElement getsubjectEdit() {
			return subjectEdit;
		}

		public WebElement getSavebtn() {
			return savebtn;
		}
		
		public void toCreateserviceContract(String subjectEdit) {
			getsubjectEdit().sendKeys(subjectEdit);
			savebtn.click();
		}
	}

