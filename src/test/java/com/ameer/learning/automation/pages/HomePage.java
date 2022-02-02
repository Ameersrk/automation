package com.ameer.learning.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ameer.learning.automation.utils.WebDriver_Helper;

public class HomePage extends BasePage{
	 WebDriver driver;
	//Constructor
	public HomePage(WebDriver driver) {
		super(driver);
		 this.driver= driver;
	}
	
	// elements
	@FindBy(id="twotabsearchtextbox")
	private WebElement _txtSearch;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement _btnSearch;
		
	// actions
	public void enterSearchText(String text) {
		_txtSearch.clear();
		 WebDriver_Helper.explicitWait(_txtSearch);
		_txtSearch.sendKeys(text);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		WebDriver_Helper.explicitWait(_btnSearch);
		_btnSearch.click();
		return new SearchResultsPage(driver);
 
	}
}
