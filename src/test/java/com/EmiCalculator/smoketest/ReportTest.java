package com.EmiCalculator.smoketest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



public class ReportTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		Reporter.log("Test for the method : "+result.getName()+" has started\n");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		Reporter.log("\nTest Successfull for the method : "+result.getName()+"\n");
		
	}

	public void onTestFailure(ITestResult result) {
		
		Reporter.log("\nTest for method "+result.getName()+" has failed\n");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		Reporter.log("\nTest for method "+result.getName()+" has been skipped\n");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
}
