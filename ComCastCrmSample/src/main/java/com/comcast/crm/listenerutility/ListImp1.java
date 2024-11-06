package com.comcast.crm.listenerutility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImp1 implements ITestListener,ISuiteListener {

	public void onStart(ISuite suite) {
		System.out.println(" onStart");
	}

	public void onFinish(ISuite suite) {
		System.out.println(" onFinish");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println(" onTestStart");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(" onTestStart");

	}
	public void onTestFailure(ITestResult result) {
		System.out.println(" onTestFailure");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("execute onTestSkipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" onTestFailedButWithinSuccessPercentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(" onTestFailedWithTimeout");
	}

	public void onStart(ITestContext context) {
		System.out.println(" onStart");
	}

	public void onFinish(ITestContext context) {
		System.out.println(" onFinish");
	}

}
