package com.selenium.helper;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	private static Config instance = null;
	private static Properties prop = null;

	private Config() {
		prop = new Properties();
		load_properties();
	}

	private void load_properties() {
		String file_path = Project.ROOT + "/src/test/resources/config/config.properties";
		try {
			prop.load(new FileInputStream(file_path));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	// static method to create instance of Singleton class
	public static Config getInstance() {
		if (instance == null)
			instance = new Config();

		return instance;
	}

	public String url() {
		return prop.getProperty("url");
	}

	public String user() {
		return prop.getProperty("user");
	}

	public String password() {
		return prop.getProperty("password");

	}

}
