package com.swaglabs.pagelayer;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product_Page {

	private WebDriver driver;

	// Constructor
	public Product_Page(WebDriver driver) {
		this.driver = driver;
	}

	// -----------------------Object Repository-------------------------------

	// Locate all product names on the page
	private By Products = By.xpath("//div[@data-test='inventory-item-name']");

	// Locate all "Add to cart" buttons for the products
	private By AddCartButtons = By.xpath("//div[@class='pricebar']//button[text()='Add to cart']");

	// Locate the checkout icon (shopping cart)
	private By CheckoutIcon = By.id("shopping_cart_container");

	// ---------------------------Action Method---------------------------------

	// Add specified product to cart by matching name
	public void addProduct(String productNameToAdd) {
		List<WebElement> productNames = driver.findElements(Products);
		List<WebElement> addToCartBtns = driver.findElements(AddCartButtons);

		boolean productFound = false;

		for (int i = 0; i < productNames.size(); i++) {
			String currentProduct = productNames.get(i).getText().trim();
			if (currentProduct.equalsIgnoreCase(productNameToAdd.trim())) {
				addToCartBtns.get(i).click();
				productFound = true;
				break;
			}
		}

		assertTrue(productFound, "Product not found or not added to cart: " + productNameToAdd);
	}

	// Click on checkout (shopping cart) icon
	public void checkoutProducts() {
		driver.findElement(CheckoutIcon).click();
	}
}
