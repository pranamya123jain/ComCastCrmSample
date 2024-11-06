package com.ComCast.crm.OrgTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatOrganisationTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExelUtility eLib=new ExelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		String Browser = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");

		String orgName = eLib.getDtaFromExcel("org", 10, 2)+jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);
		
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
		wLib.waitForPageToLoad(driver);
		
				LoginPage lp= new LoginPage(driver);//call constructor
				lp.loginToApp(USERNAME, PASSWORD, URL);//LoginPage lp= PageFactory.initElements(driver, LoginPage.class);//simplify this line^
		
		//Rule no 5 provide action==>business library
		
				HomePage hp=new HomePage(driver);//navigate to organization
				hp.getOrgLink().click();
		
				OrganizationsPage cnp=new OrganizationsPage(driver);
				cnp.getCreateNewOrgBtn().click();//click on create organization(+)
		
				CreatingNewOrganizationPage oNp=new CreatingNewOrganizationPage(driver);
				oNp.creatOrg(orgName, pindustry);//enter all the details and create new organization
				
		
				OrganizationInformationPage oip=new OrganizationInformationPage(driver);
				String actOrgName= oip.getHeaderMsg().getText();//verify the header msg
				if (actOrgName.contains (orgName)) 
						{
					System.out.println("pass");
				}
				else {
					System.out.println("fail");
				}
				//go back to organization page
				hp.getOrgLink().click();
				System.out.println("exicuted");
		
				
				
				
				
				
				//object utilization
//		lp.getUsernameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("123");
//		lp.getLoginBtn().click();
		
//		lp.usernameEdt.sendKeys("admin");
//		lp.passwordEdt.sendKeys("123");
//		lp.loginBtn.click();
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//click on organization
//			driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//		//click on create organization(+)
//			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//insert organization name
//			driver.findElement(By.name("accountname")).sendKeys(oppName);
		//click on save button
//			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
			//System.out.println("exicuted");
			//verify header msg expected result
			
		
		driver.close();
	}	
}
