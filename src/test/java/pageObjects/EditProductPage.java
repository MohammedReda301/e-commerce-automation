package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public class EditProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators for the search field, edit button, and product details
    @FindBy(xpath = "//input[@placeholder='Search for products ...']")
    WebElement searchField;

    private By editButton = By.xpath("//button[contains(@class, 'sc-cwHptR')]/a[@href='/edit/mohamed-reda']");
    @FindBy(xpath = "//input[@name='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//input[@name='price']")
    WebElement priceField;

    private By saveProductButton = By.xpath("//button[normalize-space()='Save Product']");
    private By successMessage = By.xpath("//div[@class='success-message']");

    // Constructor
    public EditProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated constructor
        PageFactory.initElements(driver, this);
    }

    // Method to search for a product by name
    public void searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(productName);
    }

    // Method to click the edit button for the product
    public void clickEditButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editButton)).click();
    }

    // Method to edit the product description and price
    public void editProductDetails() {
        wait.until(ExpectedConditions.visibilityOf(descriptionField)).clear();
        descriptionField.sendKeys("modify modify modify edit edit edit edit edit modify");

        wait.until(ExpectedConditions.visibilityOf(priceField)).clear();
        priceField.sendKeys("1212");

        // Click on the Save Product button
        wait.until(ExpectedConditions.elementToBeClickable(saveProductButton)).click();
    }

    
    
}

