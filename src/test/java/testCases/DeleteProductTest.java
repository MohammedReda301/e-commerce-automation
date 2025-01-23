package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DeleteProductPage;

public class DeleteProductTest {
    WebDriver driver;
    DeleteProductPage deleteProductPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver and initialize the page object
        driver = new ChromeDriver();
        driver.get("https://e-commerce-kib.netlify.app/");
        deleteProductPage = new DeleteProductPage(driver);
    }

    @Test
    public void testDeleteProduct() {
        // Search for the product by name
        String productName = "Mohamed Reda";
        deleteProductPage.searchForProduct(productName);

        // Wait for the product to appear and delete it
        deleteProductPage.deleteProduct();

     
    }

    // Clean up
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
