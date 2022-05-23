package com.frameWork_Practice.uility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	
	public ConfigReader()
	{
		try
		{
			File src = new File("./src/test/java/com/frameWork_Practice/utility/resources/config.properties");
			FileInputStream fs = new FileInputStream(src);
			
			prop = new Properties();
			prop.load(fs);	
		}catch (Exception e)
		{
			
		
		e.printStackTrace();
		}
	}
	
	public String getpburl()
	{
		return prop.getProperty("pburl");
	}
	
}
