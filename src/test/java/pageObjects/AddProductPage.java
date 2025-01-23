package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public AddProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated constructor
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M12,2A10,1')]")
    WebElement plusButton;

    @FindBy(xpath = "//input[@name='title']")
    WebElement titleField;

    @FindBy(xpath = "//input[@name='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//input[@name='price']")
    WebElement priceField;

    @FindBy(xpath = "//button[normalize-space()='Create Product']")
    WebElement createProductButton;

  

    @FindBy(xpath = "//input[@placeholder='Search for products ...']")
    WebElement searchField;

    // Actions
    public void clickPlusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(plusButton)).click();
        wait.until(ExpectedConditions.visibilityOf(titleField));
    }

    public void enterTitle(String title) {
        wait.until(ExpectedConditions.visibilityOf(titleField)).sendKeys(title);
    }

    public void enterDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionField)).sendKeys(description);
    }

    public void enterPrice(String price) {
        wait.until(ExpectedConditions.visibilityOf(priceField)).sendKeys(price);
    }

    public void clickCreateProductButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createProductButton)).click();
    }

 

    // New Methods for searching and verifying product
    public void searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(productName);
    }

    public boolean isProductDisplayed(String productName) {
        try {
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='" + productName + "']")));
            return product.isDisplayed();
        } catch (Exception e) {
            return false; // If the product is not found, return false
        }
    }
}
