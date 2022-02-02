package com.ameer.learning.automation.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ameer\\Documents\\GitHub\\automation\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		 
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
