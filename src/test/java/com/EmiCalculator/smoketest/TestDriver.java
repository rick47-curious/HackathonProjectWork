package com.EmiCalculator.smoketest;


import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.EmiCalculator.InputDrivers.ReadConfig;
import com.EmiCalculator.InputDrivers.ReadData;
import com.EmiCalculator.OutputDrivers.GetScreenshot;

import com.EmiCalculator.utilities.ObjectFactory;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TestDriver {
	WebDriver driver;
	ObjectFactory obj;
	ReadData rd;
	GetScreenshot gs;
	String fdata[] ;
	String pdata[];
	Logger log = Logger.getLogger(TestDriver.class);
	@BeforeSuite
	public void getDriver() throws Exception {
	
		ReadConfig rc = new ReadConfig();
		driver = rc.getDriver();
		log.info("******************************Starting the browser*************************************");

	}
	@BeforeTest
	public void getRequiredSettings() {
		driver.manage().window().maximize();
		log.info("***************************Maximizing Window*********************************************");
	}

	@BeforeClass
	public void loadSynchronization() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		obj = new ObjectFactory(driver);
		rd = new ReadData();
		gs = new GetScreenshot();
		fdata = rd.readFailedData();
		pdata = rd.readData(); 
		log.info("*********************************Smoke Testing in Progress******************************");
	}
	
	
	@Test(priority = 0,description = "Verifying the page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : Verification Title Of The Page")
	@Story("Story Name : Check Login Page Title")
	public void verifyPage() {
		log.info("***********************Verifying the page title************************");
		Assert.assertEquals("EMI Calculator for Home Loan, Car Loan & Personal Loan in India", driver.getTitle());
		log.info("**************************Test was Successfull**********************************");
	}
	
	
	@Test(priority = 1,description = "To click on the CarLoan Option")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verify and Click the CarLoan option")
	@Story("Story Name : Check CarLoan option functionality")
	public void setoption() {
		log.info("********************Setting the 'car Loan' option*******************************");
		obj.selectCarLoan();
		
		Assert.assertEquals(obj.carOption.getText(),"Car Loan","Wrong option");
		log.info("*************************Test was Successfull**********************************");
	}
	
	
	@Test(priority = 2,description = "Type in the Amount and Verify the field")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Type in the Amount and Verify the Amount Field")
	@Story("Story Name : Check the Amount Field")
	public void typeAmount()  {
		log.info("********************Inserting Amount*******************************");
		obj.getAmount(pdata[0]);
		Assert.assertEquals(obj.amountLabel.getText(), "Car Loan Amount","Wrong option");
		log.info("**********************Test was Successfull**********************************");
	}
	
	
	@Test(priority = 3,description ="Type in the InterestRate and Verify the field")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Type in the InterestRate and Verify the InterestRate Field")
	@Story("Story Name : Check the InterestField Field")
	public void typeInterest()  {
		log.info("***************************Inserting Interest Rate******************************");
		obj.getInterest(pdata[1]);
		Assert.assertEquals(obj.interestLabel.getText(), "Interest Rate","Wrong option");
		log.info("**********************Test was Successfull**********************************");
	}
	
	
	@Test(priority = 4,description = "Type in the Tenure and Verify the field")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Type in the Tenure and Verify the Tenure Field")
	@Story("Story Name : Check the Tenure Field")
	public void typeTenure() {
		log.info("************************Inserting Tenure*********************************");
		obj.getTerm(pdata[2]);
		Assert.assertEquals(obj.tenureLabel.getText(), "Loan Tenure","Wrong option");
		log.info("**********************Test was Successfull**********************************");
	}
	
	
	@Test(priority =5,description = "To check whether StartingMonth field is Enabled or not")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : To check whether StartingMonth field is Enabled or not")
	@Story("Story Name : Check whether StartingMonth is enabled or not")
	public void typeStartingMonth() {
		
		log.info("**************************Starting Month Field verification***************************");
		Assert.assertTrue(obj.startingMonth.isEnabled(), "Starting month field is not enabled");
		//log.error("****************************Starting Month Field is Disabled************************");
		log.info("**********************Test was Successfull**********************************");
	}
	
	
	@Test(priority = 6 ,description = "To Get the view of the Result in the Tabular form")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : To Get the view of the Result in the Tabular form")
	@Story("Story Name : Check the Expand Functionality")
	public void clickExpand() {
		log.info("***********************************Clickable Expand button Test******************************");
		obj.expand2020();
		log.info("************************Test was Successfull**********************************");
	}
	
	
	
	@Test(priority = 7 , description = "To get the data from the table into a Worksheet")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : To get the data from the table into a Worksheet")
	@Story("Story Name : Check whether the data are written in a worksheet")
	public void getDataInWorkbook()  {
		log.info("***********************Writing data in Excel**********************************");
		boolean result = obj.getValues();
		Assert.assertTrue(result);
		log.info("*************************Test was Successfull**********************************");
	}
	
	
	
	@Test(priority = 8,description = "To get the screenshot of the required result")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : To get the screenshot of the required result")
	@Story("Story Name : Check whether the screenshot is taken or not")
	public void takeScreenshot()  {
		log.info("**********************Taking Screenshot***************************************");
		boolean result = gs.getScreenshot(driver);
		Assert.assertTrue(result);
		log.info("***********************Test was Successfull**********************************");
	}
	
	
	
	@Test(priority = 9 , description = "Clicking the CarLoan option for Retesting")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verify and Click the CarLoan option")
	@Story("Story Name : Check CarLoan option functionality")
	public void newCarLoan() {
		log.info("*************************Retesting the the Tests with different datas***********************");
		obj.retestCarLoan();
		Assert.assertEquals(obj.carOption.getText(),"Car Loan","Wrong option");
	}
	
	
	@Test(priority = 10 , description = "Retesting the Amount field")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Retesting the Amount field")
	@Story("Story Name : Recheck the Amount field functionality")
	public void typeNewAmount() {
		obj.retestGetAmount(fdata[0]);
		Assert.assertEquals(fdata[0], "1.0","Minimum Loan Amount : 1");
	}
	
	
	@Test(priority = 11,description = "Retesting the Interest Field")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Retesting the Interest Field")
	@Story("Story Name : Recheck the Interest field functionality")
	public void typeNewInterest() {
		obj.retestGetInterest(fdata[1]);
		Assert.assertEquals(fdata[1], "5.0","Minimum Interest Rate : 5%");
	}
	
	
	@Test(priority = 12 ,description = "Retesting the Tenure Field")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Retesting the Tenure Field")
	@Story("Story Name : Recheck the Tenure field functionality")
	public void typeNewTenure() {
		obj.retestGetTenure(fdata[2]);
		Assert.assertEquals(fdata[2], "1.0","Minimum Loan Tenure is : 1 Year");
	}
	
	
	@Test(priority = 13 ,description = "To get the view of the Result in the Tabular Form")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : To Get the view of the Result in the Tabular form")
	@Story("Story Name : ReCheck the Expand Functionality")
	public void clickSecondExpand() {
		obj.expand2020();
	}
	
	
	@Test(priority = 14,description = "To get the New values in a Worksheet")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : To get the data from the table into a Worksheet")
	@Story("Story Name : ReCheck whether the data are written in a worksheet")
	public void getNewValues(){

		boolean result = obj.getNewValues();
		Assert.assertTrue(result);
	}
	
	
	@Test(priority = 15 ,description = "To get the screenshot of the updated result")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : To get the screenshot of the updated result")
	@Story("Story Name : Check whether the updated screenshot is taken or not")
	public void takesecondScreenShot() {
		boolean result = gs.getNewScreenshot(driver);
		Assert.assertTrue(result);
	}
	
	@AfterClass
	public void closeResources() {
		obj =null;
		rd = null;
		gs = null;
		fdata = null;
		pdata = null;
	}
	//@AfterTest


	@AfterSuite
	public void closeDriver() {
		driver.quit();
		log.info("*******************************Smoke Testing Ends******************************");
	}
}
