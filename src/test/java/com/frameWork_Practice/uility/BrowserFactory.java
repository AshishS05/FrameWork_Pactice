package com.frameWork_Practice.uility;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	WebDriver driver;
	ConfigReader conf = new ConfigReader();

	public WebDriver browserSelections(String browser)
	{
		ConfigReader conf = new ConfigReader();
		
		if(browser.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
		}
		else if (browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobar");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");
			Map<String,Object> prefs = new HashMap<String , Object> ();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enable",false);
			prefs.put("Download.defalt_ddirectory", System.getProperty("user.dir") +File.separator + "downnloaded File");
			options.setExperimentalOption("prefs", prefs);
		}
		else if (browser.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
		}
return driver;
	}
	

}
