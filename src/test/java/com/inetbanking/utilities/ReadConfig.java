package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class ReadConfig {

	Properties pro;
	
//constructor creating to refer this method in base class
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties(); // initiating the pro object

			pro.load(fis);

			} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());

			}
	}

	public String getApplicationURL() {

		String Url = pro.getProperty("baseUrl");
		return Url;

	}

	public String getUserName() {

		String username = pro.getProperty("username");
		return username;

	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;

	}
	
	
	public String getChromePath() {
		String chromePath=pro.getProperty("chromepath");
		return chromePath;
		
			}
	
	public String getEdgepath() {
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
	}	
		
	public String getFirefoxPath() {
		String FirefoxPath=pro.getProperty("firefoxpath");
		return FirefoxPath;
	}
	
	
	
	
}
