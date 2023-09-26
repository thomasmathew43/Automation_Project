package Indproject;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Indproject.pageobjects.AddressPage;
import Indproject.pageobjects.CartPage;
import Indproject.pageobjects.FilterPage;
import Indproject.pageobjects.LoginPage;
import Indproject.pageobjects.PaymentPage;
import Indproject.pageobjects.ProductPage;
import java.nio.file.Files;

public class MainFunctionalities extends BaseTest {

	public static final Logger logger = LogManager.getLogger(MainFunctionalities.class);

	@Test(priority = 1)

	public void start() throws IOException, InterruptedException {
		// Initialize the driver

		driver = initialize();

	}
	// SignupPage sign = new SignupPage(driver);

	@Test(priority = 2)
	public void log() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.goTo(driver);
		logger.info("Navigated to login page");
		System.out.println(login.url());
		login.loclick();
		Thread.sleep(1000);
		// login.loclick2();
		// sign.SignupApplication("rock", "tm@gmail.com", "Thomas@9880");
		// sign.signclick();

		login.loginpage("tam@gmail.com", "Thomas@9880");
		login.logclick3();
		logger.info("Logged in successfully");

	}

	@Test(priority = 3)
	public void fil() throws InterruptedException {
		// filter page
		FilterPage fil = new FilterPage(driver);
		fil.filterc1();
		fil.filterc2();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void produ() throws InterruptedException {
		// ProductPage
		ProductPage prod = new ProductPage(driver);
		String[] Items = { "The Sisters Who Would Be Queen",
				"The Privilege Of Youth: The Inspirational Story Of A Teenagers Search For Friendship And Acceptance",
				"Inside Steve's Brain" };
		prod.productcart(Items);
	}

	// After adding items to the cart, you can navigate to the cart page
	// Navigate to the cart page

	@Test(priority = 5)
	public void cartpa() {
		// Navigate to the cart page
		CartPage cartPage = new CartPage(driver);
		cartPage.goToCart();

		// Print the items in the cart
		cartPage.printCartItems();

		// Click the checkout button
		cartPage.clickCheckoutButton();
	}

	@Test(priority = 6)
	public void addres() {
		AddressPage addressPage = new AddressPage(driver);

		// Click "Add New Address" button
		addressPage.clickAddNewAddressButton();

		// Fill in address details
		addressPage.enterName("Thomas@gmail.com");
		addressPage.enterAddress("carroad,Bangalore");
		addressPage.enterCity("Game");
		addressPage.enterState("Mysore");
		addressPage.enterPostalCode("560029");
		addressPage.enterCountry("Karnataka");
		addressPage.enterPhoneNumber("7845698854");

		// Submit the form
		addressPage.clickSubmitButton();
	}

	@Test(priority = 7)
	public void paym() throws IOException {
		PaymentPage paymentPage = new PaymentPage(driver);

		// Select COD payment method
		paymentPage.selectCODPaymentMethod();

		// Get and print the confirmation message
		String confirmationMessage = paymentPage.getConfirmationMessage();
		System.out.println("Confirmation Message: " + confirmationMessage);
		logger.info("Confirmation Message: " + confirmationMessage);

		// Define the folder path for payment screenshots
		String folderPath = "payment_screenshots"; // Change this to your desired folder name
		File folder = new File(folderPath);

		// Create the folder if it doesn't exist
		if (!folder.exists()) {
			folder.mkdirs();
		}

		// Define the screenshot file path
		String screenshotFileName = "payment_screenshot1.png"; // Change the filename if needed
		String screenshotPath = folderPath + File.separator + screenshotFileName;

		// Take a screenshot and save it to the specified path
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath());

		System.out.println("Payment Screenshot saved to: " + screenshotPath);
		logger.info("Payment Screenshot saved to: " + screenshotPath);
	}

}
