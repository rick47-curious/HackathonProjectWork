package com.EmiCalculator.InputDrivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadConfig {

	WebDriver driver = null;
	public WebDriver getDriver() {
		File filePath = new File("src\\main\\resources\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Properties property = new Properties();
			property.load(fis);

			String browser = property.getProperty("browser");
			String url = property.getProperty("url");

			if ("chrome".equalsIgnoreCase(browser)) {
				driver = getChromeDriver();
				driver.get(url);
			}else if ("firefox".equalsIgnoreCase(browser)) {
				driver = getFirefoxDriver();
				driver.get(url);
			}else if ("internetexplorer".equalsIgnoreCase(browser)) {
				driver = getIEDriver();
				driver.get(url);
			}
			

		} catch (FileNotFoundException e) {

			//e.printStackTrace();
			System.out.println("No such file found in the directory");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Cannot load the properties file");
		}
		return driver;
	}

	public WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		return driver;
	}
	
	public WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		return driver;
	}
	public WebDriver getIEDriver() {
		System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		return driver;
	}
}
