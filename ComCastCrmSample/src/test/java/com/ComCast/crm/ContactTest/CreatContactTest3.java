package com.ComCast.crm.ContactTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.ContactsPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatContactTest3 {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExelUtility eLib=new ExelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
	
		String Browser = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		//FileInputStream fis1 = new FileInputStream("./testData/Demo.xlsx");
		//Workbook wb = WorkbookFactory.create(fis1);
		
		String lastName = eLib.getDtaFromExcel("contact", 1, 2)+jLib.getRandomNumber();
			
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
		
		  HomePage hp= new HomePage(driver);
		  hp.getContactLink();
		  
		  
		ContactsPage cP=new ContactsPage(driver);
		cP.creatContact(lastName);
		
		
		
		
		
		
		
		
		
		
		
		
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		//click on Contact
//			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//		//click on create organization(+)
//			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		//insert organization name
//			driver.findElement(By.name("lastname")).sendKeys(lastName);
//			
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
		
		driver.quit();
	}	
}
