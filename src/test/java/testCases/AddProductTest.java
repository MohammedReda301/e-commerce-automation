package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AddProductPage;
import utilities.DriverManager;

public class AddProductTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = DriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://e-commerce-kib.netlify.app/");
    }

    @Test
    public void testAddProduct() {
        // Initialize Page Object
        AddProductPage addProductPage = new AddProductPage(driver);

        // Perform actions to add a product
        addProductPage.clickPlusButton();
        addProductPage.enterTitle("Mohamed Reda");
        addProductPage.enterDescription("This is a test, and we have to write more than 30 characters.");
        addProductPage.enterPrice("100");
        addProductPage.clickCreateProductButton();

        
        // Verify that the product is visible in the search results
        addProductPage.searchForProduct("Mohamed Reda");

        // Check if the product is displayed in search results
        boolean isProductVisible = addProductPage.isProductDisplayed("Mohamed Reda");
        Assert.assertTrue(isProductVisible, "Product was not found in the search results!");
    }

    @AfterClass
    public void tearDown() {
        // Close the driver after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
