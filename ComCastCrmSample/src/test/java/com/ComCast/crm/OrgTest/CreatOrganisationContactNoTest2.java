package com.ComCast.crm.OrgTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatOrganisationContactNoTest2 {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExelUtility eLib=new ExelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String Browser = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");

		String orgName = eLib.getDtaFromExcel("org", 1, 2)+jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);
		String type = eLib.getDtaFromExcel("org", 4, 4);
		String phoneNo = eLib.getDtaFromExcel("org", 7, 3);
	
		System.out.println("done");
	
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
		lp.loginToApp(URL, USERNAME, PASSWORD);
				  
		//Rule no 5 provide action==>business library
		
		HomePage hp=new HomePage(driver);//navigate to organization
		hp.getOrgLink().click();
		
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();//click on create organization(+)
		
		CreatingNewOrganizationPage cNp=new CreatingNewOrganizationPage(driver);
		cNp.creatOrg(orgName, pindustry, type, phoneNo);
		driver.quit();
	}	
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		//click on organization
//			driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//		//click on create organization(+)
//			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		//insert organization name
//			driver.findElement(By.name("accountname")).sendKeys(oppName);
//			
//		//inspect dropdown
//			WebElement indEle = driver.findElement(By.name("industry")); 
//			wLib.select(indEle, industry);
//			//Select sele=new Select(indEle);
//			//sele.selectByValue(industry);
//			WebElement indEle1 = driver.findElement(By.name("accounttype")); 
//			//Select sele1=new Select(indEle1);
//			//sele1.selectByValue(type);
//		//INSPECT PHONENO
//			driver.findElement(By.id("phone")).sendKeys(phoneNo);
//				
//		//click on save button
//			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
//			System.out.println("exicuted");
//		//verify phone no industry
//			String actphone = driver.findElement(By.id("dtlview_Phone")).getText();
//		if (phoneNo.contains(actphone)) 
//		{
//			System.out.println(actphone +"is present==PASS");
//		}
//		else {
//			System.out.println(actphone+"is not present==FAIL");
//		}
//		

