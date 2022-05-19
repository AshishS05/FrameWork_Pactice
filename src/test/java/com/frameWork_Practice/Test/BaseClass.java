package com.frameWork_Practice.Test;

import java.io.DataInput;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.frameWork_Practice.uility.BrowserFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	public static WebDriver driver;
	BrowserFactory browserSelect = new BrowserFactory();
	public static Recordset record;
	String sheetName= "Sheet1";
	public static String dirPath="";
	ExtentReports report;
	public static ExtentTest logger;
	
	@SuppressWarnings("deprecation")
	@Parameters({"browser"})
	@BeforeClass(description ="Initializing driver", alwaysRun = true)
	public void initializeDriver(String browser)
	{
		driver = browserSelect.browserSelections(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	public Recordset geyValueFromSheet(String sheetName, String testcaseID) throws FilloException
	{
		Recordset record = null;
		String excelPath = ".\\TestData\\Datasheet.xlsx";
		System.out.println(excelPath);
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(excelPath);
		record = connection.executeQuery("Select * from "+sheetName+" where testCaseID = '"+testcaseID+"'");
		record.moveFirst();
		return record;
		
	}
	@Parameters({"testcaseID"})
	@BeforeClass(alwaysRun = true)
	public void initializeInputData(String testcaseID) throws FilloException
	{
		record= geyValueFromSheet(sheetName , testcaseID);
	}
	
	@BeforeTest(alwaysRun=true)
	public void reportInitilize()
	{
		dirPath=System.getProperty("user.dir")+"/ExtentReport/"+new SimpleDateFormat("ddmmyyyy_hh.mm.ss").format(new Date());
		new File(dirPath).mkdir();
		report = new ExtentReports(dirPath+File.separator+"TestAutomationReport.html",false);
		report.loadConfig(BaseClass.class, "resources" , "extent-config.xml");
	}
	
	public static void takeSceenShot(WebDriver temp, String description)
	{
		try
		{
			  File imgFile = ((TakesScreenshot) temp).getScreenshotAs(OutputType.FILE);
			  String imgPath = dirPath+"/"+description+".png";
			     FileUtils.copyFile(imgFile, new File(imgPath));
			     logger.log(LogStatus.PASS ,description + logger.addScreenCapture(imgPath));
		}catch(Exception e)
		{
			System.out.println("Issue in Taking ScreenShot");
		}
	}
	
	 

}
