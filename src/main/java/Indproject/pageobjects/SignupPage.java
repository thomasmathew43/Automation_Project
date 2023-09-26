package Indproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignupPage {
	WebDriver driver;
	Actions act;

	public SignupPage(WebDriver driver) {
		//constructor initilizattion
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		act = new Actions(driver);
		
	}
	

	// Sign up
	//WebElement elements1 = driver.findElement(By.xpath("//form/div[1]"));
	
	
	@FindBy(xpath="//form/div[1]")
	WebElement elements1;
	
	@FindBy(xpath="//form/div[2]")
	WebElement elements2;	
	
	@FindBy(xpath="//form/div[3]")
	WebElement elements3;
	
	// Sign up submit
	@FindBy(xpath="//button[@type='submit']")
	WebElement sigclick;
	
	public void SignupApplication(String signame,String sigemail,String sigpass) throws InterruptedException {
		
		act.sendKeys(elements1,signame).build().perform();
		act.sendKeys(elements2,sigemail).build().perform();
		act.sendKeys(elements3,sigpass).build().perform();
		
		
		
	}
	public void signclick() {
		sigclick.click();
	}
	
	

}
