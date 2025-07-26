package com.swaglabs.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLogin_Page {
	
	private WebDriver driver; // WebDriver instance for interacting with the browser

	// Constructor to initialize WebDriver
	public UserLogin_Page(WebDriver driver) {
		this.driver = driver;
	}

	// -------------Object Repository--------------
	
	// Locators the user input field
	private By Username = By.id("user-name");
	private By Password = By.id("password");
	private By LoginButton = By.id("login-button");
	private By menu = By.id("react-burger-menu-btn"); // menu button (for logout)
	private By LogoutOption = By.id("logout_sidebar_link");
	private By errorMessage = By.xpath("//h3[@data-test=\"error\"]"); // Locate the error message element

	//---------------------------Action Method ----------------------------------------------
	
	// Method to open the login page with the given base URL
	public void LoginPage(String baserURL) {
		driver.get(baserURL);
	}
	
	// Method to log in to the Swaglabs with given username and password
	public void loginToSwaglabs(String username, String password) {
		driver.findElement(Username).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
		driver.findElement(LoginButton).click();
	}
	
	// Method to log out from the Swaglabs
	public void logoutFromSwaglabs() {
		driver.findElement(menu).click();
		driver.findElement(LogoutOption).click();
	}
	
	// Method to get the error message text
	public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
	}

	
}
