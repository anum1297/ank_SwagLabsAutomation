package com.swaglabs.pagelayer;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrder_Page {

	private WebDriver driver;

    // Constructor to initialize the driver
	public ConfirmOrder_Page(WebDriver driver) {
		this.driver = driver;
	}

	//-----------------------Object Repository-------------------------------------
	
	//Locator
	private By confirmationMessage = By.xpath("//h2");
	
	//---------------------------Action Method ----------------------------------------------

    // Method to validate the order confirmation message
	public void validateConfirmOrder() {
		WebElement messageElement = driver.findElement(confirmationMessage);
		String actualMessage = messageElement.getText();
		assertEquals(actualMessage, "Thank you for your order!", "Confirmation message mismatch.");
	}
}
