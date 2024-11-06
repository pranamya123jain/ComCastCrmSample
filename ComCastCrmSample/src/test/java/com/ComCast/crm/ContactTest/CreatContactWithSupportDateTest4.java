package com.ComCast.crm.ContactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.ChildOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.ContactsPage;
import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


public class CreatContactWithSupportDateTest4 {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExelUtility eLib=new ExelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String Browser = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String OrgName = eLib.getDtaFromExcel("contact", 7, 2)+jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);
		String lastName = eLib.getDtaFromExcel("contact", 7, 3)+jLib.getRandomNumber();
		//String lastName = eLib.getDtaFromExcel("contact", 4, 2)+jLib.getRandomNumber();
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
		
		
		driver.get(URL);
		wLib.waitForPageToLoad(driver);
		
			LoginPage lp= new LoginPage(driver);//call constructor
			lp.loginToApp(USERNAME, PASSWORD, URL);
		  
			HomePage hp=new HomePage(driver); //navigate to organization
			hp.getOrgLink().click();
	
			OrganizationsPage cnp=new OrganizationsPage(driver);//click on create organization(+)
			cnp.getCreateNewOrgBtn().click();
	
			CreatingNewOrganizationPage oIp=new CreatingNewOrganizationPage(driver);//enter all the details and create new organization
			oIp.creatOrg(OrgName, pindustry);
			
			Thread.sleep(2000);
			hp.getContactLink();//click on contact page
		  
		  
			ContactsPage cP=new ContactsPage(driver);
			cP.creatContact(lastName);
			
			wLib.SwitchToTabToURL(driver, "module=Accounts&action");//switch to child window
			ChildOrganizationPage cOp=new ChildOrganizationPage(driver);
			cOp.creatChildOrg(OrgName);
			driver.findElement(By.xpath("//a[text()='"+OrgName+"']"));
		
			wLib.SwitchToTabToURL(driver, "module=Contacts&action");//switch to parent window
			
			String startDate=jLib.getSystemDateYYYYMMDD();
			String endDate=jLib.getRequiredDateYYYYMMDD(30);
			cP.creatContact(startDate, endDate);
			
			cP.getSaveBtn().click();
		
			//verify LastName
			String actName = cP.getActLastName().getText();
			if (actName.equals(lastName)) {
			System.out.println(actName+"is present==PASS");
			}
		else {
				System.out.println(actName+"is not present==FAIL");
			}
		
			//verify Satrt Date
		String actdateSrtaDate = cP.getActStartDate().getText();
			if (actdateSrtaDate.equals(startDate )) 
			{
				System.out.println(actdateSrtaDate +"is present==PASS");
			}
			else {
				System.out.println(actdateSrtaDate+"is not present==FAIL");
			}
		
			//verify Enddate 
		String actEndDate = cP.getActEndDate().getText();
			if (actEndDate.equals(endDate)) {
				System.out.println(actEndDate +"is present==PASS");
				
			}
		else {
				System.out.println(actEndDate+"is not present==FAIL");
			}
		
		
//		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		//click on Contact
//			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//		//click on create Contact(+)
//			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//			
//			String startDate=jLib.getSystemDateYYYYMMDD();
//			String endDate=jLib.getRequiredDateYYYYMMDD(30);
////			Date dateObj= new Date();
////			SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
////			String startDate=sim.format(dateObj);
////			Calendar cal=sim.getCalendar();
////			cal.add(Calendar.DAY_OF_MONTH,30);
////			String endDate=sim.format(cal.getTime());
//			
//		//insert Contact name
//			driver.findElement(By.name("lastname")).sendKeys(lastName);
//			driver.findElement(By.name("support_start_date")).clear();
//			driver.findElement(By.name("support_start_date")).sendKeys(startDate);
//			Thread.sleep(3000);
//			driver.findElement(By.name("support_end_date")).clear();
//			Thread.sleep(3000);
//			driver.findElement(By.name("support_end_date")).sendKeys(endDate);
//		//click on save button
//			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
//			System.out.println("exicuted");
//			
//			//verify header contact
//			String actheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if (actheader.contains(lastName )) 
//		{
//			System.out.println(actheader +"is present==PASS");
//		}
//		else {
//			System.out.println(actheader+"is not present==FAIL");
//		}
//		//verify LastName 
//		String actName = driver.findElement(By.id("dtlview_Last Name")).getText();
//		if (actName.equals(lastName)) {
//			System.out.println(actName +"is present==PASS");
//			
//		}
//		else {
//			System.out.println(actName+"is not present==FAIL");
//		}
//		//verify Satrt Date
//		String actdateSrtaDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
//		if (actdateSrtaDate.contains(startDate )) 
//		{
//			System.out.println(actdateSrtaDate +"is present==PASS");
//		}
//		else {
//			System.out.println(actdateSrtaDate+"is not present==FAIL");
//		}
//		//verify Enddate 
//		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
//		if (actEndDate.equals(endDate)) {
//			System.out.println(actEndDate +"is present==PASS");
//			
//		}
//		else {
//			System.out.println(actEndDate+"is not present==FAIL");
//		}
		
		driver.quit();
	}	
}
