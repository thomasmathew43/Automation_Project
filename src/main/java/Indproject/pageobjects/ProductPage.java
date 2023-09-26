package Indproject.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		// initilizattion
		this.driver = driver;
		// new LoginPage()
		PageFactory.initElements(driver, this);

	}

	// List<WebElement> tom = driver.findElements(By.cssSelector(".book-title"));
	@FindBy(css = ".book-title")
	public List<WebElement> tom;

	@FindBy(css = ".card-text button")
	public List<WebElement> bookTitles;

	// String[] Items = { "Chinese Cinderella: The Secret Story Of An Unwanted
	// Daughter"};


	public void productcart(String[] Items) throws InterruptedException {
    	int j = 0;

		for (int i = 0; i < tom.size(); i++) 
		{
			String name = tom.get(i).getText();
			List<String> itemsNeededList = Arrays.asList(Items);
			if (itemsNeededList.contains(name)) 
			{
				j++;
				driver.findElements(By.cssSelector(".card-text button")).get(i).click();
				Thread.sleep(1000);
				if (j == Items.length)
				{
					break;
				}
			}
		}   
}
}
