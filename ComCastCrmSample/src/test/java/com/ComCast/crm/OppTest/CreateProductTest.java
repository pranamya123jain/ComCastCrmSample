package com.ComCast.crm.OppTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectrepositoryUtility.CreateNewProductPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.ObjectrepositoryUtility.ProductInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.ProductPage;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateProductTest {

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
			hp.getproductsLink().click();

			ProductPage pg = new ProductPage(driver);
			pg.getcreateProductLink().click();

			// read test data from excel
			String produname = eLib.getDtaFromExcel("Product", 1, 2);
			CreateNewProductPage cnpp = new CreateNewProductPage(driver);
			cnpp.toCreateProduct(produname);

			// verify the product is added or not
			ProductInformationPage prip = new ProductInformationPage(driver);
			String headerinfo = prip.getHeaderMsg().getText();
			if (headerinfo.contains(produname)) {
				System.out.println("product added");
			} else {
				System.out.println("product not added");
			}
			Thread.sleep(2000);
			hp.logout();
			driver.quit();

	}

}
