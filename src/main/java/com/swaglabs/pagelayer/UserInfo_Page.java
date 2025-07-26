package com.swaglabs.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfo_Page {

	private WebDriver driver; // WebDriver instance for interacting with the browser

	// Constructor to initialize WebDriver
	public UserInfo_Page(WebDriver driver) {
		this.driver = driver;
	}

	// -------------Object Repository--------------

	// WebElement declarations using POM - Basic Approach
	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By postCode = By.id("postal-code");
	private By continueButton = By.id("continue");

	// ---------------Action Method ----------

	// Method to submit user information
	public void submitUserInfo(String FirstName, String LastName, String PostalCode) {

		driver.findElement(firstName).sendKeys(FirstName);// Enter first name in the input field
		driver.findElement(lastName).sendKeys(LastName);// Enter last name in the input field
		driver.findElement(postCode).sendKeys(PostalCode);// Enter postal code in the input field
		driver.findElement(continueButton).click();
		;// click on the continue button
	}
}
