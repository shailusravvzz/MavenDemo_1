package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.commons.lang3.RandomStringUtils;

import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig Readconfig=new ReadConfig();
	

	public String baseUrl = Readconfig.getApplicationURL();
	public String username = Readconfig.getUserName();
	public String password = Readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;
	
	
	// Static keyword for variable means it is Global variable
	
	@Parameters("Browser")
	@BeforeClass
	public void setup(String br) {
		  
		logger = LogManager.getLogger("ebanking");
				
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Readconfig.getChromePath());
			driver=new ChromeDriver();   //instantiating webDriver
			
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", Readconfig.getFirefoxPath());
			driver=new FirefoxDriver();   //instantiating webDriver
			
		}else if (br.equals("edge")) {
			//System.setProperty("webdriver.ie.driver", Readconfig.getIEpath());
			//driver=new InternetExplorerDriver();   //instantiating webDriver
			System.setProperty("webdriver.edge.driver", Readconfig.getEdgepath());
			driver=new EdgeDriver();
		}
		
		driver.get(baseUrl);
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		
		//File target=new File("./Screenshots"+tname+".png");
		
		File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		
		FileUtils.copyFile(source, target);
		
		System.out.println("Screen Shot Taken Successfully");
		
	}

	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
}
	}

