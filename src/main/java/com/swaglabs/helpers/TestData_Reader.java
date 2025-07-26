package com.swaglabs.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData_Reader {

	// Properties object to store configuration data
	public Properties properties;

	// Constructor to initialize ConfigReader and load properties file
	public TestData_Reader() {
		properties = new Properties();
		try {

			// Load the properties file from the specified path
			FileInputStream fis = new FileInputStream("src\\main\\java\\com\\swaglabs\\utilities\\TestData.properties");
			properties.load(fis); // Load properties from the input stream
		} catch (IOException e) {
			e.printStackTrace();

			// Throw a runtime exception if properties file loading fails
			throw new RuntimeException("Unable to load properties file: " + e.getMessage());
		}
	}

	// Method to retrieve property value based on key
	public String getProperty(String key) {
		return properties.getProperty(key); // Return the value associated with the specified key
	}

}
