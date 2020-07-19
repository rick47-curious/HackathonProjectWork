package com.EmiCalculator.OutputDrivers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {

	WebDriver driver;
	public boolean getScreenshot(WebDriver driver)  {
		try {
		TakesScreenshot srcshot = (TakesScreenshot)driver;
		
		File snapshot = srcshot.getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new Date());
		
			FileUtils.copyFile(snapshot, new File("src\\test\\resources\\screenshotpassed"+timestamp+".jpg"));
		} catch (IOException e) {
			
			System.out.println("Screenshot not taken");
			return false;
		}
		return true;
	}
	
	public boolean getNewScreenshot(WebDriver driver)  {
		try {
		TakesScreenshot srcshot = (TakesScreenshot)driver;
		
		File snapshot = srcshot.getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new Date());
		
			FileUtils.copyFile(snapshot, new File("src\\test\\resources\\screenshotfailed"+timestamp+".jpg"));
		} catch (IOException e) {
			
			System.out.println("Screenshot not taken");
			return false;
		}
		return true;
	}
}
