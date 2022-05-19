package com.frameWork_Practice.uility;

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
		}
		else if (browser.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
		}
return driver;
	}
	

}
