package com.EmiCalculator.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ObjectFactoryRt {

	WebDriver driver;
	public ObjectFactoryRt(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Selector for CarLoan Option
	@FindBy(id="car-loan")
	public WebElement option;

	//Amount slider Selector
	@FindBy(xpath = "(//span[@style='left: 20%;'])[1]")
	WebElement sliderInitialAmt;

	//Amount slider selector
	@FindBy(xpath = "(//span[@style='left: 75%;'])[1]")
	WebElement sliderFinalAmt;

	//InterestRate selector
	@FindBy(xpath = "(//span[@style='left: 50%;'])[2]")
	WebElement sliderInitialInt;

	//Interest Rate selector
	@FindBy(xpath = "//span[@style='left: 30%;']")
	WebElement sliderFinalInt;

	//Tenure Selector
	@FindBy(xpath = "//span[@style='left: 71.4286%;']")
	WebElement sliderInitialTenure;

	//Tenure Selector
	@FindBy(xpath = "//span[@style='left: 14.2857%;']")
	WebElement sliderFinalTenure;

	//Expand Button
	@FindBy(id = "year2020")
	WebElement btn;


	@Step("To click the CarLoan Option and Verify whether Clickable or not")
	public void clickOption() {
		option.click();
	}


	@Step("To select the Amount using the slider")
	public void moveAmountSlider() {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@style='left: 20%;'])[1]")));
		Actions action = new Actions(driver);

		action.clickAndHold(sliderInitialAmt).build().perform();
		action.moveByOffset(355, 0).build().perform();
		action.release(sliderFinalAmt).build().perform();


	}

	
	@Step("To select the InterestRate using the slider")
	public void moveInterestSlider() {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@style='left: 50%;'])[2]")));
		Actions action = new Actions(driver);

		action.clickAndHold(sliderInitialInt).build().perform();
		action.moveByOffset(-125, 0).build().perform();
		action.release(sliderFinalInt).build().perform();


	}


	
	@Step("To select the Tenure using the slider")
	public void moveTenureSlider() {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@style='left: 71.4286%;']")));
		Actions action = new Actions(driver);

		action.clickAndHold(sliderInitialTenure).build().perform();

		action.moveByOffset(-370, 0).build().perform();
		action.release(sliderFinalTenure).build().perform();


	}

	
	@Step("To display the required table corresponding to the Input")
	public void expand2020()  {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", btn);
		jse.executeScript("arguments[0].click()",btn);

	}



}
