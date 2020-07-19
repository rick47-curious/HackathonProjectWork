package com.EmiCalculator.regressiontest;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

import com.EmiCalculator.InputDrivers.ReadConfig;

import com.EmiCalculator.OutputDrivers.GetScreenshot;

import com.EmiCalculator.utilities.ObjectFactoryRt;


import io.qameta.allure.*;


public class DriverRegressionTest {
	WebDriver driver;
	GetScreenshot gs;
	ObjectFactoryRt obj;
	Logger log = Logger.getLogger(DriverRegressionTest.class);
	@BeforeSuite
	public void getDriver() throws Exception {
		ReadConfig rc = new ReadConfig();
		driver = rc.getDriver();
		log.info("***************************Starting the Browser*****************************");
	}
	
	@BeforeTest
	public void getRequiredSettings() {
		driver.manage().window().maximize();
		log.debug("******************************Maximizing the Window*********************************");
	}
	
	@BeforeClass
	public void loadSynchronization() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		gs = new GetScreenshot();
		obj = new ObjectFactoryRt(driver);
		log.debug("*******************************Regression Testing is in Progress************************");
		
	}
	
	
	@Test(priority = 0,description = "Verifying the page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : To verify the page Title")
	@Story("Story Name : Check the Page Title")
	public void verifyPage() {
		log.info("***********************Verifying the page title************************");
		Assert.assertEquals("EMI Calculator for Home Loan, Car Loan & Personal Loan in India", driver.getTitle());
		log.info("**************************Test was Successfull**********************************");
	}
	
	
	@Test(priority = 1,description ="To click on the CarLoan Option")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verify and Click the CarLoan option")
	@Story("Story Name : Check CarLoan option functionality")
	public void setoption() {
		log.info("********************Setting the 'car Loan' option*******************************");
		obj.clickOption();
		
		Assert.assertEquals(obj.option.getText(),"Car Loan","Wrong option");
		log.info("**************************Test was Successfull**********************************");
	}
	
	
	@Test(priority = 2,description = "Select the Amount using the Slider")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Select the Amount using the Slider")
	@Story("Story Name : Check Amount slider functionality")
	public void setLoanAmount() 
	{
		log.info("********************Inserting Amount*******************************");
		obj.moveAmountSlider();
		log.info("**************************Test was Successfull**********************************");
	}
	
	
	
	@Test(priority = 3,description = "Select the InterestRate using the Slider")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Select the InterestRate using the Slider")
	@Story("Story Name : Check InterestRate slider functionality")
	public void setInterest() 
	{
		log.info("***************************Inserting Interest Rate******************************");
		obj.moveInterestSlider();
		log.info("**************************Test was Successfull**********************************");
	}
	
	
	
	@Test(priority = 4,description = "Select the Tenure using the Slider")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Select the Tenure using the Slider")
	@Story("Story Name : Check Tenure slider functionality")
	public void setTenure()
	{
		log.info("************************Inserting Tenure*********************************");
		obj.moveTenureSlider();
		//Thread.sleep(3000);
		log.info("**************************Test was Successfull**********************************");
	}
	
	
	@Test(priority = 5,description = "To Get the view of the Result in the Tabular form")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : To Get the view of the Result in the Tabular form")
	@Story("Story Name : Check the Expand Functionality")
	public void getOutput() {
		log.info("***********************************Clickable Expand button Test******************************");
		obj.expand2020();
		log.info("**************************Test was Successfull**********************************");
	}
	
	
	
	@Test(priority = 6,description = "To get the screenshot of the required result")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : To get the screenshot of the required result")
	@Story("Story Name : Check whether the screenshot is taken or not")
	public void getScreenshot() {
		log.info("**********************Taking Screenshot***************************************");
		gs.getScreenshot(driver);
		log.info("**************************Test was Successfull**********************************");
	}
	@AfterSuite
	public void closeDriver() {
		driver.quit();
		log.info("*******************************Regression Testing Ends******************************");
	}
}
