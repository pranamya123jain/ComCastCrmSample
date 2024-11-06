package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {
	public static ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		// spark report config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");// time stamp
		spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");// specify the location of
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

	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {// get execute before executing each testcase
		System.out.println("===" + result.getMethod().getMethodName() + "==START==");
		test = report.createTest(result.getMethod().getMethodName());// creating tc inside extent report
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "===>Test is started<===");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("===" + result.getMethod().getMethodName() + "==END==");
		test.log(Status.INFO, result.getMethod().getMethodName() + "===>Test is completd<===");
	}

	public void onTestFailure(ITestResult result) {// if any tc failed
		String testName = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");// time stamp
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===>FAILED<===");
		test.log(Status.FAIL, result.getThrowable() + "===>FAILED<===");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===>Skipped<===");
		test.log(Status.FAIL, result.getThrowable() + "===>Skipped<===");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}

}
