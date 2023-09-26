package Indproject.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
public class PaymentPage {
    private WebDriver driver;

    @FindBy(id = "COD")
    private WebElement codPaymentMethod;

    @FindBy(xpath = "//body/div[@id='root']/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]")
    private WebElement confirmationMessage;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectCODPaymentMethod() {
        codPaymentMethod.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String takeScreenshot(String screenshotPath) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath());
        return screenshotPath;
    }
}

