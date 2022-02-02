package com.ameer.learning.automation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ameer.learning.automation.utils.WebDriver_Helper;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	 
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")
	private WebElement _txtiPhone;

	 public void getElementText() {
	 String value	= _txtiPhone.getText();
	 System.out.println("Text" + value);
	 
	 }
	

	public ItemDetailsPage clickOnItem() {
		WebDriver_Helper.explicitWait(_txtiPhone);
		_txtiPhone.click();
		
		Set <String> WinIDS= driver.getWindowHandles();
	       
	       Iterator<String> ITR= WinIDS.iterator();
	       String Fst = ITR.next();
	       String Snd = ITR.next();
	       driver.switchTo().window(Snd);
	       System.out.println(driver.switchTo().window(Snd).getTitle());
		
		
		
		/*String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}
		}*/
		
		return new ItemDetailsPage(driver);
	}
	}


