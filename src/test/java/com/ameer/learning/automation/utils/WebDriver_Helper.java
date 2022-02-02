package com.ameer.learning.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Helper extends BaseTest {
 
	public static void implicitWait() {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 }
	public static void explicitWait(String element) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
	}
	
	public static void explicitWait(WebElement element) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
}


