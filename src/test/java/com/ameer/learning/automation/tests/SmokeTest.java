package com.ameer.learning.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ameer.learning.automation.pages.HomePage;
import com.ameer.learning.automation.pages.ItemDetailsPage;
import com.ameer.learning.automation.pages.SearchResultsPage;
import com.ameer.learning.automation.utils.BaseTest;
import com.ameer.learning.automation.utils.ExcelReader;

public class SmokeTest extends BaseTest{
	private static final Logger log= LogManager.getLogger(SmokeTest.class);
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ItemDetailsPage itemDetailsPage;

	
	@DataProvider(name = "DataFromExcel")

	  public static Object[][] ExcelSheet() throws Exception {

	  Object[][] Arr= ExcelReader.MESdata("C:/Users/Ameer/Documents/GitHub/automation/Datafiles/ExcelReader_TestNG.xlsx","AmazonIndia");
       
	   System.out.println(Arr[0][1].toString()); //just used to check
	   return Arr;
	}
	
	@Test (dataProvider = "DataFromExcel")
	public void verifyhomepage( String Mobiles, String Tablets, String Devices) throws InterruptedException {
		
		log.info("Test Started with Log");
		System.out.println(" Test Case ");
		//System.out.println(Arr[0][0].toString());
		
		homePage.enterSearchText(Mobiles);
		searchResultsPage=homePage.clickOnSearchButton();
		searchResultsPage.getElementText();
		itemDetailsPage=searchResultsPage.clickOnItem();
		itemDetailsPage.getExchangeDetails();
	
		//getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
	    //getDriver().findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);

	}
	
	@BeforeClass
	public void setup() {
		homePage = new HomePage(getDriver());
	} 

}
