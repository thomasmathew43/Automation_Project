package Indproject.pageobjects;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class LoginPage {

	WebDriver driver;
	Actions act;

	public LoginPage(WebDriver driver) {
		// initilizattion
		this.driver = driver;
		// new LoginPage()
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	// Login up
	// WebElement elements1 = driver.findElement(By.xpath("//form/div[1]"));

	// Start page clicking
	@FindBy(xpath = "//div/nav/div/div[2]/a[3]")
	WebElement stclick1;

	// click signup
	@FindBy(css = "a[class='text-center']")
	WebElement stclick2;

	// login
	@FindBy(xpath = "//form/div[1]")
	WebElement login1;

	@FindBy(xpath = "//form/div[2]")
	WebElement login2;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement logclick;

	@Test
	public void loginpage(String logEmail, String logpass) throws InterruptedException {

		act.sendKeys(login1, logEmail).build().perform();
		act.sendKeys(login2, logpass).build().perform();

	}

	@Test
	public void goTo(WebDriver driver) {

		driver.get("https://www.99bookscart.com/");

	}

	@Test
	public String url() {
		String url = driver.getCurrentUrl();
		return url;
	}

	@Test
	public void loclick() throws InterruptedException {
		stclick1.click();

	}

	@Test
	public void loclick2() throws InterruptedException {
		stclick2.click();
		Thread.sleep(1000);
	}
	@Test
	public void logclick3() {
		logclick.click();
	}

}
