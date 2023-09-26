package Indproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterPage {
	
	WebDriver driver;


	public FilterPage(WebDriver driver) {
		// initilizattion
		this.driver = driver;
		// new LoginPage()
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Non Fiction')]")
	WebElement filter1;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/a[7]/span[1]")
	WebElement filter2;
	
	public void filterc1() {
		filter1.click();
	}
	public void filterc2() {
		filter2.click();
	}
	


}
