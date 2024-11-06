package practiceTestNg;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleExtentReportsTest {
	ExtentReports report;

	@BeforeSuite
	public void configBS() {
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");// specify the location of
		// folder wr u want to store
		spark.config().setDocumentTitle("CRM testSuite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add environment information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("Browser", "CHROME-100");
	}

	@AfterSuite
	public void configAS() {
		report.flush();
	}

	@Test
	public void createContactTest() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");

		TakesScreenshot eDriver = (TakesScreenshot) driver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("Create contact");
		test.log(Status.INFO, "Login to app");// u have to specify the status of the log//status is just info
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "Create contact");
		if ("HDFC".equals("HD")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		}
		driver.close();
	}

	@Test
	public void createContactWithOrgTest() {
		ExtentTest test = report.createTest("Create contact");
		test.log(Status.INFO, "Login to app");// u have to specify the status of the log//status is just info
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "Create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}

	@Test
	public void createContactWithPhoneNoOrgTest() {
		ExtentTest test = report.createTest("Create contact");
		test.log(Status.INFO, "Login to app");// u have to specify the status of the log//status is just info
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "Create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}
}
