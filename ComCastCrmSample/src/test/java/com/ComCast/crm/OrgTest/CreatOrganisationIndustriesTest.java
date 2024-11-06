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

public class CreatOrganisationIndustriesTest {

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
		String type = eLib.getDtaFromExcel("org", 4, 4);
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);
		
		//String industry = sh.getRow(4).getCell(3).toString();
		//String type = sh.getRow(4).getCell(4).toString();
				
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
		lp.loginToApp(USERNAME, PASSWORD, URL);
				  
		//Rule no 5 provide action==>business library
		
		HomePage hp=new HomePage(driver);//navigate to organization
		hp.getOrgLink().click();
		
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();//click on create organization(+)
		
		CreatingNewOrganizationPage cNp=new CreatingNewOrganizationPage(driver);
		cNp.creatOrg(orgName, pindustry, type);
		
		OrganizationInformationPage oIp=new OrganizationInformationPage(driver);
		String indDD = oIp.getIndustryDD().getText();
	if (indDD.contains(pindustry)) 
		{
			System.out.println(pindustry +"is present==PASS");
		}
		else {
			System.out.println(pindustry+"is not present==FAIL");
		}
	
		//verify type expected result
	
		String actType = oIp.getTypeDD().getText();
		if (actType.contains(type)) 
		{
			System.out.println(type +"info is correct==PASS");
		}
		else {
			System.out.println(type +"info is correct==FAIL");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
//			Select sele=new Select(indEle);
//			sele.selectByValue(industry);
//			//driver.findElement(By.xpath("//input[@name='button_Industry']")).click();
//		
//			WebElement indEle1 = driver.findElement(By.name("accounttype")); 
//			Select sele1=new Select(indEle1);
//			sele1.selectByValue(type);
//			//driver.findElement(By.name("button_Type")).click();
//				
//		//click on save button
//			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
//			System.out.println("exicuted");
//			//verify Drop down industry
//			String indDD = driver.findElement(By.id("dtlview_Industry")).getText();
//		if (indDD.contains(industry)) 
//		{
//			System.out.println(industry +"is present==PASS");
//		}
//		else {
//			System.out.println(industry+"is not present==FAIL");
//		}
//		
//		//verify type expected result
//		String actType = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if (actType.equals(type)) 
//		{
//			System.out.println(type +"info is correct==PASS");
//		}
//		else {
//			System.out.println(type +"info is correct==FAIL");
//		}
		driver.quit();
	}	
}
