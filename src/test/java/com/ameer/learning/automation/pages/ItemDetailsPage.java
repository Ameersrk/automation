package com.ameer.learning.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ameer.learning.automation.utils.WebDriver_Helper;

public class ItemDetailsPage extends BasePage {

	public ItemDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\"maxBuyBackDiscountSection\"]/span[1]/span/span")
	private WebElement txtExchange;

	public void getExchangeDetails() {
		WebDriver_Helper.explicitWait(txtExchange);
		System.out.println("Exchange Details" + txtExchange.getText());
	}
 

}
