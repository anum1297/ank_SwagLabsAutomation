package com.swaglabs.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Reusable_page {

	private WebDriver driver;

	// Constructor to initialize the WebDriver
	public Reusable_page(WebDriver driver) {
		this.driver = driver;
	}

	// ------------------------object Repository-------------------

	// WebElement representing the homepage name element
	private By HomePageName = By.cssSelector("div[class='app_logo']");

	// ------------------------Action Method ----------------------

	// Method to get the homepage name and assert its value
	public void getHomePageName() {
		WebElement WE = driver.findElement(HomePageName);
		String HomePage = WE.getText(); // Get text of the homepage name element
		Assert.assertEquals(HomePage, "Swag Labs"); // Assert that the homepage name matches "Swag Labs"
	}

}
