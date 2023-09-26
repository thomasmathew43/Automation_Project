package basicmain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Indproject.pageobjects.LoginPage;
import Indproject.pageobjects.SignupPage;
import basicfunctionalities.BLoginPage;
import basicfunctionalities.BSignupPage;

public class Bmain extends dataReader {

	public WebDriver driver;

	public void setup() {
		start st = new start();
		driver = st.init();
	}

	@Test(dataProvider="getData")
	public void loginTest(HashMap<String,String> input) throws InterruptedException {
		start st = new start();
		driver = st.init();
		BLoginPage log = new BLoginPage(driver);
		// LoginPage login = new LoginPage(driver);

		Thread.sleep(1000);
		// login.loclick2();
		// sign.SignupApplication("rock", "tm@gmail.com", "Thomas@9880");
		// sign.signclick();

		log.loginpage(input.get("email"), input.get("password"));
		log.logclick3();
		String name = driver.findElement(By.className("red-text")).getText();
		System.out.println(name);
		// driver.quit();

	}

	
	public void signup(String namee, String email, String pass) throws InterruptedException {
		start st = new start();
		driver = st.siginit();
		BSignupPage sign = new BSignupPage(driver);
		Thread.sleep(1000);
		sign.sig(namee, email, pass);
		sign.signclick();
		String name = driver.findElement(By.className("red-text")).getText();
		System.out.println(name);
		
	}

	/*
	 * @DataProvider public Object[][] getdata(){ return new Object[][]
	 * {{"tam@gmail.com","Thomas@9880"}, {"tmm@gmail.com","Thomas@9880"}}; }
	 * 
	 * @DataProvider public Object[][] getdata1(){ return new Object[][]
	 * {{"rock","tjjm@gmail.com","Thomas@9880"},
	 * {"rocka","toom@gmail.com","Thomas@9880"}}; }
	 */
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//testData.json");
		return new Object[][]{ { data.get(0) }, { data.get(1) } ,{data.get(2)}};

	}


}
