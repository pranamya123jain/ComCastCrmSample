package com.ComCast.crm.OppTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.ChildOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOpportunityPage;
import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.ObjectrepositoryUtility.OpportunitiesPage;
import com.comcast.crm.ObjectrepositoryUtility.OpportunityInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatOpportunityTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExelUtility eLib=new ExelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String Browser = fLib.getDataFromPropertiesFile("browser");
		String URL =fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		//data from Opportunity excel page
		String oppName=eLib.getDtaFromExcel("Opportunity", 1, 2)+jLib.getRandomNumber();
		String orgName=eLib.getDtaFromExcel("Opportunity", 4, 2)+jLib.getRandomNumber();
	
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
		driver.get(URL);
		String parentId = driver.getWindowHandle();
		wLib.waitForPageToLoad(driver);
	
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD, URL);
		
		HomePage  hp=new HomePage(driver);
		hp.getOrgLink().click();//click on organization link
		
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();//click on create new org +

		CreatingNewOrganizationPage oIp=new CreatingNewOrganizationPage(driver);
		oIp.creatOrg(orgName);//enter org name//click on save
		Thread.sleep(2000);
		
		hp.getOpportunityLink().click();//click on opportunity link
		
		OpportunitiesPage oP=new OpportunitiesPage(driver);
		oP.getCreatNewOpportunityBtn().click();//create opp +
		
		CreatingNewOpportunityPage cnop=new CreatingNewOpportunityPage(driver);
		cnop.creatOpportunity(oppName);//enter opp name and click on +
		
		wLib.SwitchToTabToURL(driver, "Accounts&action");//switch to child window
		
		ChildOrganizationPage cO=new ChildOrganizationPage(driver);
		cO.creatChildOrg(orgName);//enter org name and click on search button in child popup
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		wLib.SwitchToTabToURL(driver, "module=Potentials");//switch to parent window

		cnop.getSaveBtn().click();
		
		
		//OppIp.getOpportunityInformation();
		OpportunityInformationPage oppIp=new OpportunityInformationPage(driver);
		String actOppName=oppIp.getHeaderMsg().getText();
		if (actOppName.contains(oppName)) {	
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		driver.quit();
		
		
		
		
		
		
		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		// click on opportunities
//		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
//		// click on create opportunities
//		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
//		// enter opportunity name
//		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(oppName+randomInt);
//		// enter related to +
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
//		 Set<String>childID=driver.getWindowHandles();
//		 for(String wh:childID)
//		 {
//			 if(!wh.equals(parentId))
//				 driver.switchTo().window(wh);
//		 }
//			driver.findElement(By.xpath("//a[text()='techPyramid']")).click();
//			Thread.sleep(5000);
//			System.out.println("hiii");
//			//click on save button
//			WebElement ele = driver.findElement(By.xpath("//b[.='Opportunity Information:']/ancestor::tr/preceding-sibling::tr/descendant::input[@class='crmbutton small save']"));
//			ele.click();
//			System.out.println("exicuted");
//		
	}

}
