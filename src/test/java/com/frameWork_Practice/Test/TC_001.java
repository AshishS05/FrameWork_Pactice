package com.frameWork_Practice.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.frameWork_Practice.uility.ConfigReader;

public class TC_001 extends BaseClass {
	ConfigReader config = new ConfigReader();
	
	@Parameters({"browser"})
	@Test(testName = "Naigate to URl", enabled = true , priority =1 )
	public void navigation(String browser)
	{
		driver.get(config.getpburl());
		takeSceenShot(driver , "URL it successfully");
	
		//driver.quit();
}
	@Test(testName = "Naigate to URl", enabled = false , priority =2 )
	public void readData() throws FilloException
	{
		
		String name = record.getField("Name");
		System.out.println(name);
		
	}
	}
	