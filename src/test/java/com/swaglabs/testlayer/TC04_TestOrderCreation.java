package com.swaglabs.testlayer;

import org.testng.annotations.Test;

import com.swaglabs.driver.TestBase;
import com.swaglabs.pagelayer.CheckOut_Page;
import com.swaglabs.pagelayer.ConfirmOrder_Page;
import com.swaglabs.pagelayer.ProductOverview_Page;
import com.swaglabs.pagelayer.Product_Page;
import com.swaglabs.pagelayer.UserInfo_Page;

public class TC04_TestOrderCreation extends TestBase {

	// Test method to create an order
	@Test
	public void createOrder() {
		// Step 1: Open the login page of the application
		LogPage.LoginPage(DataReader.getProperty("baseURL"));

		// Step 2: Perform login using valid credentials
		LogPage.loginToSwaglabs(DataReader.getProperty("username"), DataReader.getProperty("password"));

		// Step 3: Add products to the cart
		Product_Page pg = new Product_Page(driver);
		pg.addProduct(DataReader.getProperty("product1"));

		// Step 4: Proceed to checkout
		pg.checkoutProducts();

		// Step 5: Validate products in the checkout page and initiate the checkout
		CheckOut_Page cp = new CheckOut_Page(driver);
		cp.checkProductExists(DataReader.getProperty("product1"));
		cp.checkOutOrder();

		// Step 6: Proceed with checkout by submitting user information
		UserInfo_Page ip = new UserInfo_Page(driver);
		ip.submitUserInfo(DataReader.getProperty("firstName"), DataReader.getProperty("lastName"),
				DataReader.getProperty("postalCode"));

		// Step 7: Validate overview page before confirming the order
		ProductOverview_Page op = new ProductOverview_Page(driver);
		op.validateOverviewPage(DataReader.getProperty("product1"));

		// Step 8: Validate order confirmation after placing the order
		ConfirmOrder_Page ocp = new ConfirmOrder_Page(driver);
		ocp.validateConfirmOrder();
	}

}
