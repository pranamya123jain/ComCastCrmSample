package com.comcast.crm.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	public FileUtility fLib = new FileUtility();
	public ExelUtility eLib = new ExelUtility();
	public DatabaseUtility dbLib = new DatabaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = {"smoke test","regression test"})
	public void configBSTest() throws Throwable {
		System.out.println("Connect to DB, Repor config");
		dbLib.getDBConnection();

	}

	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke test","regression test"})
	public void configBCTest(@Optional("chrome") String browser) throws Throwable {
		// public void configBCTest(String browser) throws Throwable
		// public void configBCTest() throws Throwable{
		System.out.println("Launch the browser");
		// String Browser= fLib.getDataFromPropertiesFile("browser");
		String Browser = browser;
		System.out.println(Browser);
		if (Browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(sdriver);
	}

	@BeforeMethod(groups = {"smoke test","regression test"})
	public void configBMTest() throws Throwable {
		System.out.println("Login");

		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");

		LoginPage lp = new LoginPage(driver);// call constructor
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = {"smoke test","regression test"})
	public void configAMTest() {

		System.out.println("Logout");
		HomePage hP = new HomePage(driver);
		hP.logout();
	}

	@AfterClass(groups = {"smoke test","regression test"})
	public void configACTest() {
		System.out.println("Close Browser");
		driver.quit();
	}

	@AfterSuite(groups = {"smoke test","regression test"})
	public void configASTest() {
		System.out.println("Close DB connection,rReport backup");
		try {
			dbLib.closeConnection();
		} catch (Exception e) {
			
		}
	}
}
