package com.tutorialsNinja.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.tutorialsNinja.Utilities.Util;

public class TestBase {
	public WebDriver driver;
	public ChromeOptions options;
	public Properties prop;
	public FileInputStream ip;
	public FileInputStream ip1;
	public Properties dataProp;
	
	public TestBase() throws IOException {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+
		"//src//main//java//com//tutorialsNinja//config//Config.properties");
		prop.load(ip);
		
		dataProp = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+
		"//src//test//java//com//tutorialsnNinja//TestData//testData.properties"); 
		dataProp.load(ip);
		
	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if(browserName.equals("chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation","disable-infobars"));
			driver = new ChromeDriver(options);
			
		}else if(browserName.equals("firefox")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.setExperimentalOption("excludesSwitches",Arrays.asList("enable-automation","disable-infobars"));
			driver = new ChromeDriver(options);
			
		}if(browserName.equals("Edge")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.setExperimentalOption("excludesSwitches",Arrays.asList("enable-automation","disable-infobars"));
			driver = new ChromeDriver(options);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGWLOAD_TIME_WAIT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME_WAIT));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
