package com.Ecommerce.Utility_data;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Ecommerce.Baseclass.Ecommerce_baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class Listners extends Ecommerce_baseclass implements ITestListener {

	ExtentTest test;	
	ExtentReports extent = Extent_Report.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		//Extent Report 
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}
 
	public void onTestSuccess(ITestResult result) {
		//Extent Report
		extentTest.get().log(Status.PASS, "Test Passed");
	}	
	public void onTestFailure(ITestResult result) {
	
	 //Screenshot	
		extentTest.get().fail(result.getThrowable());
		
		String testmethodname=result.getMethod().getMethodName();
		
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		try {
			extentTest.get().addScreenCaptureFromPath(getscreenshotAS(testmethodname),result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}


}