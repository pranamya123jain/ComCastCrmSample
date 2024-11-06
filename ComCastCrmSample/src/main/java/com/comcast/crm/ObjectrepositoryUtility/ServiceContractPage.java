package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceContractPage {

		WebDriver driver;
		public ServiceContractPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//img[@alt='Create Service Contract...']")
		private WebElement serviceContractLink;
		
		public WebElement getServiceContractLink() {
			return serviceContractLink;
		}
	}

