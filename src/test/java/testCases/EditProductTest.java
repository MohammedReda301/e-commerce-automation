package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.EditProductPage;

public class EditProductTest {
    WebDriver driver;
    EditProductPage editProductPage; // Declaring the EditProductPage variable

    @BeforeClass
    public void setup() {
        // Setup WebDriver and initialize the page object
        driver = new ChromeDriver();  // Assuming you've set up the ChromeDriver path in the system
        driver.get("https://e-commerce-kib.netlify.app/");
        editProductPage = new EditProductPage(driver);  // Corrected initialization
    }

    @Test
    public void editProductTest() {
        // Step 1: Search for the product by name
        String productName = "Mohamed Reda";  // Replace with the actual product name
        editProductPage.searchForProduct(productName);

        // Step 2: Click the edit button
        editProductPage.clickEditButton();

        // Step 3: Edit the product details
        editProductPage.editProductDetails();

    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver after test execution
        if (driver != null) {
            driver.quit();
        }
    }
}
