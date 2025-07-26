package com.swaglabs.testlayer;

import org.testng.annotations.Test;

import com.swaglabs.driver.*;


public class TC01_TestLoginFunctionality extends TestBase{
	
    // Test method to validate login functionality
    @Test
    public void LoginTest() {
        // Step 1: Open the login page of the application
        LogPage.LoginPage(DataReader.getProperty("baseURL"));
        
        // Step 2: Perform login using valid credentials
        LogPage.loginToSwaglabs(DataReader.getProperty("username"), DataReader.getProperty("password"));
    }

}
