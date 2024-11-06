package com.ComCast.crm.OppTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.CreateNewLeadPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LeadInfoPage;
import com.comcast.crm.ObjectrepositoryUtility.LeadPage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateLeadTest {

		public static void main(String[] args) throws Throwable {
			FileUtility fLib=new FileUtility();
			ExelUtility eLib=new ExelUtility();
			JavaUtility jLib=new JavaUtility();
			WebDriverUtility wLib=new WebDriverUtility();
			
			String Browser = fLib.getDataFromPropertiesFile("browser");
			String URL =fLib.getDataFromPropertiesFile("url");
			String USERNAME = fLib.getDataFromPropertiesFile("Username");
			String PASSWORD = fLib.getDataFromPropertiesFile("Password");
			
			WebDriver driver = null;
			if (Browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (Browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (Browser.equals("edge")) {
				driver = new EdgeDriver();
			} else {
				driver = new ChromeDriver();
			}

			// Login
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(URL,USERNAME, PASSWORD);

			HomePage hp = new HomePage(driver);
			hp.getleadLink().click();

			LeadPage leadp = new LeadPage(driver);
			leadp.getCreateLeadLink().click();

			// read test data from excel
			String lastname = eLib.getDtaFromExcel("Lead", 1, 2);
			String company = eLib.getDtaFromExcel("Lead", 4, 2);

			CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
			cnlp.toCreateLead(lastname, company);
			
			
			// verify the header msg expected result
			LeadInfoPage lip=new LeadInfoPage(driver);
			String headerInfo = lip.getHeaderMsg().getText();
			if (headerInfo.contains(lastname)) {
				System.out.println(lastname + " is created ==Pass");
			} else {
				System.out.println(lastname + " is not created ==FAIL");
			}
			hp.logout();
			driver.quit();
		}


	}

