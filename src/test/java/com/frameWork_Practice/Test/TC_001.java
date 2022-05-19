package com.frameWork_Practice.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

public class TC_001 extends BaseClass {
	
	@Parameters({"browser"})
	@Test(testName = "Naigate to URl", enabled = true , priority =1 )
	public void navigation(String browser)
	{
		driver.get("https://www.google.com");
		takeSceenShot(driver , "URL it successfully");
	
		driver.quit();
}
	@Test(testName = "Naigate to URl", enabled = false , priority =2 )
	public void readData() throws FilloException
	{
		
		String name = record.getField("Name");
		System.out.println(name);
		
	}
	}
	