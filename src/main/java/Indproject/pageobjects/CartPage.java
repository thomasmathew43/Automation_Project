package Indproject.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//div/nav/div/div[2]/a[2]")
    public WebElement cartLink;

    @FindBy(css = ".MuiTypography-root.MuiTypography-subtitle2.css-c7dfze")
    public List<WebElement> cartItems;

    @FindBy(css = ".MuiButtonBase-root.MuiButton-containedPrimary")
    private WebElement checkoutButton;
   
    public void goToCart() {
        cartLink.click();
    }

    public void printCartItems() {
        System.out.println("Items in the Cart:");
        for (WebElement cartItem : cartItems) {
            System.out.println(cartItem.getText());
        }
    }
    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
