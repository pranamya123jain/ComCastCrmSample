package com.ComCast.crm.OppTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.CreateNewTroubleTicketsPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.ObjectrepositoryUtility.TroubleInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.TroubleTicketPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateTroubleTicketsandverify {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExelUtility eLib=new ExelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String Browser = fLib.getDataFromPropertiesFile("browser");
		String URL =fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");

		WebDriver driver=null;
		if(Browser.equals("Chrome"))
			{
			driver=new ChromeDriver();
			}
		else if(Browser.equals("Firefox"))
			{
			driver=new FirefoxDriver();
			}
		else if (Browser.equals("edge")) 
			{
			driver=new EdgeDriver();
			}
		else {
			driver=new ChromeDriver();
		}
		// Login
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD, URL);
		
		HomePage hp = new HomePage(driver);
		hp.gettroubleTicketsLink().click();

		TroubleTicketPage ttp = new TroubleTicketPage(driver);
		ttp.getCreateTroubleLink().click();

		// read test data from excel
		String title = eLib.getDtaFromExcel("Trouble", 1, 2);
		
		
		CreateNewTroubleTicketsPage cnttp = new CreateNewTroubleTicketsPage(driver);
		cnttp.toCreateTicket(title);
		
		
		// Verify header information
		TroubleInformationPage tip = new TroubleInformationPage(driver);
		String headerinfo = tip.getHeaderMsg().getText();
		
		if (headerinfo.contains(title)) {
			System.out.println(title + " Is verified ==PASS");
		} else {
			System.out.println(title + " Is not verified ==FAILL");
		}
		hp.logout();
		driver.quit();

	}

}
