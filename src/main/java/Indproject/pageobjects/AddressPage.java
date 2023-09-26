package Indproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    public WebDriver driver;
    public Actions actions;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }
    
    @FindBy(xpath = "//button[contains(text(),'Add New Address')]")
    public WebElement addNewAddressButton;

    @FindBy(id = "name")
    public WebElement nameInput;

    @FindBy(xpath = "//form/div[3]")
    public WebElement addressInput;

    @FindBy(xpath = "//form/div[4]")
    public WebElement cityInput;

    @FindBy(xpath = "//form/div[5]")
    public WebElement stateInput;

    @FindBy(xpath = "//form/div[6]")
    public WebElement postalCodeInput;

    @FindBy(xpath = "//form/div[7]")
    public WebElement countryInput;

    @FindBy(xpath = "//form/div[8]")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    

    public void clickAddNewAddressButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addNewAddressButton);
    }

    public void enterName(String name) {
        nameInput.clear();
        actions.sendKeys(nameInput, name).build().perform();
    }

    public void enterAddress(String address) {
        actions.sendKeys(addressInput, address).build().perform();
    }

    public void enterCity(String city) {
        actions.sendKeys(cityInput, city).build().perform();
    }

    public void enterState(String state) {
        actions.sendKeys(stateInput, state).build().perform();
    }

    public void enterPostalCode(String postalCode) {
        actions.sendKeys(postalCodeInput, postalCode).build().perform();
    }

    public void enterCountry(String country) {
        actions.sendKeys(countryInput, country).build().perform();
    }

    public void enterPhoneNumber(String phoneNumber) {
        actions.sendKeys(phoneNumberInput, phoneNumber).build().perform();
    }

    public void clickSubmitButton() {
        actions.click(submitButton).build().perform();
    }
}
