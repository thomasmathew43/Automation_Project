package Indproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Indproject.pageobjects.SignupPage;

public class keep2 {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) throws InterruptedException, IOException {
			// TODO Auto-generated method stub
			WebDriver driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://www.99bookscart.com/");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			SignupPage sign= new SignupPage(driver);
			driver.findElement(By.xpath("//div/nav/div/div[2]/a[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("a[class='text-center']")).click();
			Thread.sleep(1000);

			Actions act = new Actions(driver);

			// Sign up
			WebElement elements1 = driver.findElement(By.xpath("//form/div[1]"));
			act.sendKeys(elements1, "Thomas Mathew").build().perform();

			WebElement elements2 = driver.findElement(By.xpath("//form/div[2]"));
			act.sendKeys(elements2, "thomas@gmail.com").build().perform();

			WebElement elements3 = driver.findElement(By.xpath("//form/div[3]"));
			act.sendKeys(elements3, "Thomas@9880").build().perform();

			// Sign up submit
			driver.findElement(By.xpath("//form/div[4]")).click();

			// Login
			WebElement elementl1 = driver.findElement(By.xpath("//form/div[1]"));
			act.sendKeys(elementl1, "thomas@gmail.com").build().perform();

			WebElement elementl2 = driver.findElement(By.xpath("//form/div[2]"));
			act.sendKeys(elementl2, "Thomas@9880").build().perform();
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			driver.findElement(By.xpath("//a[contains(text(),'Non Fiction')]")).click();
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/a[7]/span[1]")).click();

			Thread.sleep(3000);

			// Cartpage
			String[] Items = { "You Dont Have To Say You Love Me","The Lady In The Van" ,"Captain Class"};

			List<WebElement> tom = driver.findElements(By.cssSelector(".book-title"));

			int j = 0;

			for (int i = 0; i < tom.size(); i++) {
				String name = tom.get(i).getText();
				List<String> itemsNeededList = Arrays.asList(Items);
				if (itemsNeededList.contains(name)) {
					j++;
					driver.findElements(By.cssSelector(".card-text button")).get(i).click();
					Thread.sleep(1000);
					if (j == Items.length) {
						break;
					}
				}
			}
			// System.out.println(tom.getText());

			// After adding items to the cart, you can navigate to the cart page
			driver.findElement(By.xpath("//div/nav/div/div[2]/a[2]")).click();

			// Get the list of items in the cart
			List<WebElement> cartItems = driver
					.findElements(By.cssSelector(".MuiTypography-root.MuiTypography-subtitle2.css-c7dfze"));

			// Print the items in the cart
			System.out.println("Items in the Cart:");
			for (WebElement cartItem : cartItems) {
				System.out.println(cartItem.getText());
			}
			// for checkout click
			driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-containedPrimary")).click();
			
			WebElement ele2 = driver.findElement(By.xpath("//button[contains(text(),'Add New Address')]"));
			JavascriptExecutor executor2 =(JavascriptExecutor)driver;
			executor2.executeScript("arguments[0].click();",ele2);
			
			Thread.sleep(2000);
			// checkout form filling
			driver.findElement(By.id("name")).clear();

			WebElement sh1 = driver.findElement(By.id("name"));
			act.sendKeys(sh1, "Thomas@gmail.com").build().perform();

			// Element not intractbale
			// driver.findElement(By.xpath("//form/div[6]")).sendKeys("Thomas");
			
			WebElement sh3 = driver.findElement(By.xpath("//form/div[3]"));
			act.sendKeys(sh3, "carroad,Bangalore").build().perform();

			WebElement sh4 = driver.findElement(By.xpath("//form/div[4]"));
			act.sendKeys(sh4, "Game").build().perform();

			WebElement sh5 = driver.findElement(By.xpath("//form/div[5]"));
			act.sendKeys(sh5, "Mysore").build().perform();

			WebElement sh6 = driver.findElement(By.xpath("//form/div[6]"));
			act.sendKeys(sh6, "560029").build().perform();

			WebElement sh7 = driver.findElement(By.xpath("//form/div[7]"));
			act.sendKeys(sh7, "Karnataka").build().perform();

			WebElement sh8 = driver.findElement(By.xpath("//form/div[8]"));
			act.sendKeys(sh8, "7845698854").build().perform();

			WebElement sh9 = driver.findElement(By.xpath("//button[@type='submit']"));
			act.click(sh9).build().perform();
			
			driver.findElement(By.id("COD")).click();
			
			String name =driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]")).getText();
			System.out.println(name);
			 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        String screenshotPath = "path_to_save_screenshot.png"; // Change this to your desired path

		        // Copy the screenshot file to your desired location
		        Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath());


			// Close the browser
			// driver.quit();
		}
	}
