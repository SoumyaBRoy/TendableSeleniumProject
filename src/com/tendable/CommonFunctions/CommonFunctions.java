package com.tendable.CommonFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonFunctions {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public void loadPropertiesFile()
	{
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\com\\tendable\\Properties\\config.properties");
		
		try 
		{
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		dataProp = new Properties();
		File testDataPropFile = new File(System.getProperty("user.dir")+"\\src\\com\\tendable\\Resources\\testData.properties");
		
		try
		{
		FileInputStream testDatafis = new FileInputStream(testDataPropFile);
		dataProp.load(testDatafis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public WebDriver initializebrowser(String browserName) 
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firfox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		
		return driver;
	}

}
