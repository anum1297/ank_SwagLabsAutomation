package com.swaglabs.pagelayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckOut_Page {

	private WebDriver driver;

	// Constructor
	public CheckOut_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	//-----------------------Object Repository-------------------------------------

	// Locators
	private By checkoutProducts = By.xpath("//div[@data-test='inventory-item-name']");
	private By checkoutButton = By.id("checkout");
	private By removeButtons = By.xpath("//button[text()='Remove']");

	//---------------------------Action Method ----------------------------------------------

	// Validate that a specific product is listed in the checkout
	public void checkProductExists(String productName) {
		List<WebElement> products = driver.findElements(checkoutProducts);
		boolean found = false;
		for (WebElement product : products) {
			if (product.getText().equalsIgnoreCase(productName)) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(found, "Product not found in the checkout: " + productName);
	}

	// Remove a specific product from the checkout list
	public void dropProduct(String productName) {
		List<WebElement> products = driver.findElements(checkoutProducts);
		List<WebElement> removeBtns = driver.findElements(removeButtons);

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equalsIgnoreCase(productName)) {
				removeBtns.get(i).click(); // Click corresponding remove button
				break;
			}
		}
	}

	// Click the checkout button to proceed with order
	public void checkOutOrder() {
		driver.findElement(checkoutButton).click();
	}
}
