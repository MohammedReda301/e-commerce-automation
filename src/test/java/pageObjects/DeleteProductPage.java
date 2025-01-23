package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locator for search field and product card
    @FindBy(xpath = "//input[@placeholder='Search for products ...']")
    WebElement searchField;

    private By productCard = By.xpath("//div[contains(text(), 'Mohamed Reda')]");
    private By deleteButton = By.xpath(".//following-sibling::div//button[2]"); // Delete button within the product card
   

    // Constructor
    public DeleteProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated constructor
        PageFactory.initElements(driver, this);
    }
    

    // Method to search for a product by name
    public void searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(productName);
    }

    // Method to delete the product
    public void deleteProduct() {
        // Wait for the product to be visible after search
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productCard));
        WebElement deleteBtn = productElement.findElement(deleteButton);
        deleteBtn.click();
    }

    
    
}