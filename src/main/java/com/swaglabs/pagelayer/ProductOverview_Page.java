package com.swaglabs.pagelayer;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductOverview_Page {

	private WebDriver driver;

	// Constructor
	public ProductOverview_Page(WebDriver driver) {
		this.driver = driver;
	}

	// -----------------------Object Repository------------------------------
	// Locators
	private By confirmedProducts = By.xpath("//div[@data-test='inventory-item-name']");
	private By finishButton = By.id("finish");

	// ---------------------------Action Method -------------------------------

	// Method to validate a product is present on the overview page and finish order
	public void validateOverviewPage(String productName) {
		List<WebElement> products = driver.findElements(confirmedProducts);

		boolean found = false;
		for (WebElement product : products) {
			if (product.getText().equalsIgnoreCase(productName)) {
				found = true;
				break;
			}
		}

		assertTrue(found, "Product '" + productName + "' not found on the overview page.");
		driver.findElement(finishButton).click();
	}
}
