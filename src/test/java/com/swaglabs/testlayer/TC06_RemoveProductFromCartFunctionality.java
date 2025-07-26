package com.swaglabs.testlayer;

import org.testng.annotations.Test;

import com.swaglabs.driver.TestBase;
import com.swaglabs.pagelayer.CheckOut_Page;
import com.swaglabs.pagelayer.Product_Page;

public class TC06_RemoveProductFromCartFunctionality extends TestBase {

	// Test method to verify product removal from cart functionality
	@Test
	public void verifyProductRemovalfromCart() {
		// Step 1: Open the login page of the application
		LogPage.LoginPage(DataReader.getProperty("baseURL"));

		// Step 2: Perform login using valid credentials
		LogPage.loginToSwaglabs(DataReader.getProperty("username"), DataReader.getProperty("password"));

		// Step 3: Add products to the cart
		Product_Page pg = new Product_Page(driver);
		pg.addProduct(DataReader.getProperty("product1"));

		// Step 4: Proceed to checkout
		pg.checkoutProducts();

		// Step 5: Validate products in the checkout page
		CheckOut_Page cp = new CheckOut_Page(driver);
		cp.checkProductExists(DataReader.getProperty("product1"));

		// Step 6: Remove a product from the cart
		cp.dropProduct(DataReader.getProperty("product1"));
	}

}
