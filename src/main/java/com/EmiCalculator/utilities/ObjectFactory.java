package com.EmiCalculator.utilities;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EmiCalculator.OutputDrivers.WriteData;

import io.qameta.allure.Step;

public class ObjectFactory {

	WebDriver driver = null;
	public ObjectFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#car-loan>a")
	public WebElement carOption;

	@FindBy(xpath = "//*[@id='loanamount']//preceding::label[1]")
	public WebElement amountLabel;

	@FindBy(xpath = "//*[@id='loaninterest']//preceding::label[1]")
	public WebElement interestLabel;

	@FindBy (xpath  = "//*[@id='loanterm']//preceding::label[1]")
	public WebElement tenureLabel;

	@FindBy(id = "loanamount")
	public WebElement amount;

	@FindBy(id ="loaninterest")
	public WebElement interest;

	@FindBy(id = "loanterm")
	public WebElement term;

	@FindBy(id = "year2020")
	public WebElement btn;

	//Get the month name
	@FindBy(xpath = "//*[@id='monthyear2020']//table//tbody//tr[1]//child::td[1]")
	public WebElement month;

	//Get the principal 
	@FindBy(xpath = "//*[@id='monthyear2020']//table//tbody//tr[1]//child::td[2]")
	public WebElement principalamt;

	//Get the Interest
	@FindBy(xpath = "//*[@id='monthyear2020']//table//tbody//tr[1]//child::td[3]")
	public WebElement interestamt;

	//Type the starting month
	@FindBy(id = "startmonthyear")
	public WebElement startingMonth;


	
	@Step("To click the CarLoan Option and Verify whether Clickable or not")
	public void selectCarLoan() {
		carOption.click();
	}


	
	@Step("To type in the Amount: {0} in the required field")
	public void getAmount(String amountData)  {

		amount.clear();
		amount.sendKeys(Keys.BACK_SPACE);
		amount.sendKeys(amountData);

	}

	
	@Step("To type in the Interest Rate : {0} in the required field")
	public void getInterest(String interestData)  {

		interest.clear();
		interest.sendKeys(Keys.BACK_SPACE);
		interest.sendKeys(interestData);
	}

	
	@Step("To type in the Tenure : {0} in the required field")
	public void getTerm(String tenureData)  {

		term.clear();
		term.sendKeys(Keys.BACK_SPACE);
		term.sendKeys(tenureData);
	}

	
	@Step("To display the required table corresponding to the Input")
	public void expand2020()  {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", btn);
		jse.executeScript("arguments[0].click()",btn);

	}

	
	@Step("To get all the Values in the Excel sheet")
	public boolean getValues() {

		String firstMonth = month.getText();
		String principal = principalamt.getText();
		String interest = interestamt.getText();

		WriteData wd = new WriteData();
		boolean result = wd.getData(firstMonth,principal,interest);
		if (result==true)
			return true;
		else 
			return false;
	}

	
	@Step("Retesting the CarLoan option")
	public void retestCarLoan() {
		driver.navigate().refresh();
		carOption.click();
	}

	
	@Step("Retesting the Amount with the given Value : {0}")
	public void retestGetAmount(String amountData) {
		amount.clear();
		amount.sendKeys(Keys.BACK_SPACE);
		amount.sendKeys(amountData);
	}

	
	@Step("Retesting the InterestRate field with the given value : {0}")
	public void retestGetInterest(String interestData) {
		interest.clear();
		interest.sendKeys(Keys.BACK_SPACE);
		interest.sendKeys(interestData);
	}

	
	@Step("Retesting the Tenure field with the given value : {0}")
	public void retestGetTenure(String tenureData) {
		term.clear();
		term.sendKeys(Keys.BACK_SPACE);
		term.sendKeys(tenureData);
	}

	
	@Step("Get all the updated datas from the new table displayed")
	public boolean getNewValues() {
		String firstMonth = month.getText();
		String principal = principalamt.getText();
		String interest = interestamt.getText();

		WriteData wd = new WriteData();
		boolean result = wd.getFailedData(firstMonth,principal,interest);

		if (result==true)
			return true;
		else 
			return false;

	}
}
