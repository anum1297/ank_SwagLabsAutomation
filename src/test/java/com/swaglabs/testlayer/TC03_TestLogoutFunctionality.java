package com.swaglabs.testlayer;

import org.testng.annotations.Test;

import com.swaglabs.driver.TestBase;

public class TC03_TestLogoutFunctionality extends TestBase {

	// Test method to validate logout functionality
	@Test
	public void LogoutTest() {
		// Step 1: Open the login page of the application
		LogPage.LoginPage(DataReader.getProperty("baseURL"));

		// Step 2: Perform login using valid credentials
		LogPage.loginToSwaglabs(DataReader.getProperty("username"), DataReader.getProperty("password"));

		// Step 3: Perform logout using the LogoutFromApplication method
		LogPage.logoutFromSwaglabs();
	}

}
