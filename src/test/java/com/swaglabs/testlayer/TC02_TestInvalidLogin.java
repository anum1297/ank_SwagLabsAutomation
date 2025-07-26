package com.swaglabs.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.driver.TestBase;

public class TC02_TestInvalidLogin extends TestBase{
	
	// Test method to validate invalid login scenario
    @Test
    public void testInvalidLogin() {
        
        // Read invalid credentials from properties file
        String invalidUsername = DataReader.getProperty("invalidUsername");
        String invalidPassword = DataReader.getProperty("invalidPassword");

        // Step 1: Open the login page of the application
        LogPage.LoginPage(DataReader.getProperty("baseURL"));

        // Step 2: Attempt login with invalid credentials
        LogPage.loginToSwaglabs(invalidUsername, invalidPassword);

        // Step 3: Verify that an appropriate error message is displayed
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = LogPage.getErrorMessage(); // Fetch the error message displayed
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Epic sadface: Sorry, this user has been locked out."); // Assert that the error message matches the expected message
    }

}
