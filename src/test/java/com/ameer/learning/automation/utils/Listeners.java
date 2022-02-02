package com.ameer.learning.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners implements ITestListener {
	
	protected static ExtentReports report;
	protected static ExtentSparkReporter reports;
	protected static ExtentTest test;
	
	

	public void onTestStart(ITestResult result) {
		 System.out.println("Test Started");
		 test= report.createTest(result.getMethod().getMethodName());
		 test.log(Status.INFO, result.getMethod().getMethodName() + "Test Starts");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed");
		test.log(Status.INFO, result.getMethod().getMethodName() + "Test passes");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		test.log(Status.INFO, result.getMethod().getMethodName() + "Test Fails");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");
		test.log(Status.INFO, result.getMethod().getMethodName() + "Test Skips");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Passed with percentage");
		test.log(Status.INFO, result.getMethod().getMethodName() + "Test Failed with Success %");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test Failed on Timeout");
		test.log(Status.INFO, result.getMethod().getMethodName() + "Test Fails on Timeout");
	}

	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started");
		System.out.println("The name of the Testcase is: " + context.getName());
		report = new ExtentReports();
		reports = new ExtentSparkReporter("target/" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date())+ "report.html");
		//reports = new ExtentSparkReporter("target/report.html");
		report.attachReporter(reports);
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finish");
		report.flush();
	}

}
