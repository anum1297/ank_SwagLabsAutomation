package com.swaglabs.testlayer;

import org.testng.annotations.Test;

import com.swaglabs.driver.TestBase;
import com.swaglabs.pagelayer.CheckOut_Page;
import com.swaglabs.pagelayer.Product_Page;

public class TC05_TestAddToCartFunctionality extends TestBase {

	// Test method to verify adding a product to the cart functionality
	@Test
	public void verifyProductAdditionToCart() {
		// Open the login page of the application
		LogPage.LoginPage(DataReader.getProperty("baseURL"));

		// Perform login using provided credentials
		LogPage.loginToSwaglabs(DataReader.getProperty("username"), DataReader.getProperty("password"));

		// Instantiate ProductPage object using WebDriver instance
		Product_Page pg = new Product_Page(driver);

		// Add a specified product to the cart
		pg.addProduct(DataReader.getProperty("product1"));

		// Proceed to checkout from the product page
		pg.checkoutProducts();

		// Instantiate CheckoutPage object using WebDriver instance
		CheckOut_Page cp = new CheckOut_Page(driver);

		// Validate that the specified product is in the checkout page
		cp.checkProductExists(DataReader.getProperty("product1"));
	}

}
