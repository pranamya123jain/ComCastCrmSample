package com.ComCast.crm.OppTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.CampaignPage;
import com.comcast.crm.ObjectrepositoryUtility.CreateNewCampaignPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateCampaignTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExelUtility eLib=new ExelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String Browser = fLib.getDataFromPropertiesFile("browser");
		String URL =fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String campaignName=eLib.getDtaFromExcel("Campaigns", 1, 2);
		
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(URL,USERNAME, PASSWORD);
			
			HomePage hp = new HomePage(driver);
			hp.navigatetoMore();
			hp.navigateToCampaignspage();
			
			CampaignPage cP=new CampaignPage(driver);
			cP.getcreateCampaignLink().click();
			
			CreateNewCampaignPage cNcP=new CreateNewCampaignPage(driver);
			cNcP.toCreateCampaign(campaignName);
			
			
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (headerInfo.contains(campaignName)) {
			System.out.println(campaignName + "is created==PASS");
			} else {
					System.out.println(campaignName + "is not created==FAIL");
					}

					driver.quit();
					
	}
	
}
