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
import com.comcast.crm.ObjectrepositoryUtility.OpportunityInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		ExelUtility eLib = new ExelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		String Browser = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");

//			Random random = new Random();
//			int randomInt = random.nextInt(50);

//	FileInputStream fis1 = new FileInputStream("./testData/Demo.xlsx");
//	Workbook wb = WorkbookFactory.create(fis1);
		String OrgName = eLib.getDtaFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);
		String lastName = eLib.getDtaFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		System.out.println("done");

		WebDriver driver = null;
		if (Browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		String parentId = driver.getWindowHandle();
		wLib.waitForPageToLoad(driver);

		driver.get(URL);
		wLib.waitForPageToLoad(driver);

		LoginPage lp = new LoginPage(driver);// call constructor
		lp.loginToApp(USERNAME, PASSWORD, URL);

		HomePage hp = new HomePage(driver); // navigate to organization
		hp.getOrgLink().click();

		OrganizationsPage cnp = new OrganizationsPage(driver);// click on create organization(+)
		cnp.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage oIp = new CreatingNewOrganizationPage(driver);// enter all the details and create
																					// new organization
		oIp.creatOrg(OrgName, pindustry);

		Thread.sleep(2000);
		hp.getContactLink();// click on contact page

		ContactsPage cP = new ContactsPage(driver);
		cP.creatContact(lastName);

		wLib.SwitchToTabToURL(driver, "module=Accounts&action");// switch to child window
		ChildOrganizationPage cOp = new ChildOrganizationPage(driver);
		cOp.creatChildOrg(OrgName);
		driver.findElement(By.xpath("//a[text()='" + OrgName + "']"));

		wLib.SwitchToTabToURL(driver, "module=Contacts&action");// switch to parent window

		cP.getSaveBtn().click();

		String actLastName = cP.getHeaderMsg().getText();
		if (actLastName.contains(lastName)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

//			
//			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
//			
//		//click on organization
//			driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//		//click on create organization(+)
//			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		//insert organization name
//			driver.findElement(By.name("accountname")).sendKeys(OrgName);
//		//click on save button
//			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
//			System.out.println("exicuted");
//			Thread.sleep(3000);
//		//click on Contact
//			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//		//click on create Contact(+)
//			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		//enter all the details and create new organisaion
//			driver.findElement(By.name("lastname")).sendKeys(lastName);
//			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
//			
//			//switch to child window
//			wLib.SwitchToTabToURL(driver, "module=Accounts");
//
//			driver.findElement(By.name("search_text")).sendKeys(OrgName);
//			driver.findElement(By.name("search")).click();
//			driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).sendKeys(lastName);
//			
//			//switch to parent window
//			wLib.SwitchToTabToURL(driver, "module=Contacts");
//			
//			//click on save button
//			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
//			System.out.println("exicuted");
//			
//			//verify LastName 
//			String actName = driver.findElement(By.id("dtlview_Last Name")).getText();
//			if (actName.trim().equals(lastName)) {
//				System.out.println(actName +"is present==PASS");
//				
//			}
//			else {
//				System.out.println(actName+"is not present==FAIL");
//			
//		
//		}
		driver.close();
	}

}
