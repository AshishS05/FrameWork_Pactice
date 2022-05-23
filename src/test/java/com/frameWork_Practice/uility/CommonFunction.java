package com.frameWork_Practice.uility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction {
	WebDriver driver;
	 int count;

	
	
	public void switchTab() {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext())
		{
			String child_window = I1.next();
					if(!parent.equals(child_window))
						driver.switchTo().window(child_window);
		}
	

}
	
	public void explicitWait(WebDriver driver , By WebElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		 
        wait.until(ExpectedConditions.visibilityOfElementLocated(WebElement));
	}
	

	public void waitGreaterThan(WebDriver driver , By WebElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		 
       
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(WebElement,count));
	
}
	public void waitLessThan(WebDriver driver , By WebElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		 
       
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(WebElement,count));
	
}
	public void clickablityWait(WebDriver driver , By WebElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		 
       
		wait.until(ExpectedConditions.elementToBeClickable(WebElement));
	
}
	
	public static String fn_GetTimeStamp(){
		DateFormat DF=DateFormat.getDateTimeInstance();
		Date dte=new Date();
		String DateValue=DF.format(dte);
		DateValue=DateValue.replaceAll(":", "_");
		DateValue=DateValue.replaceAll(",", "");
		return DateValue;
		}
	
	public static String fn_TakeSnapshot(WebDriver driver, String DestFilePath) throws IOException  {
		String TS=fn_GetTimeStamp();
		TakesScreenshot tss=(TakesScreenshot) driver;
		File srcfileObj= tss.getScreenshotAs(OutputType.FILE);
		DestFilePath=DestFilePath+TS+".png";
		File DestFileObj=new File(DestFilePath);
		FileUtils.copyFile(srcfileObj, DestFileObj);
		return DestFilePath;
		}
	public static void fn_Select(WebElement WE, String VisibleText){
		Select selObj=new Select(WE);
		selObj.selectByVisibleText(VisibleText);
		}
	
	
}


