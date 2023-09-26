package basicfunctionalities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BLoginPage {

	WebDriver driver;
	Actions act;

	public BLoginPage(WebDriver driver) {
		// initilizattion
		this.driver = driver;
		// new LoginPage()
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	// login
	@FindBy(xpath = "//form/div[1]")
	WebElement login1;

	@FindBy(xpath = "//form/div[2]")
	WebElement login2;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement logclick;

	public void loginpage(String logEmail, String logpass) throws InterruptedException {

		act.sendKeys(login1, logEmail).build().perform();
		act.sendKeys(login2, logpass).build().perform();

	}

    public void logclick3() {
        logclick.click();
    }
  
}
