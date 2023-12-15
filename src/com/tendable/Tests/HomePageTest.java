package com.tendable.Tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tendable.CommonFunctions.CommonFunctions;

public class HomePageTest extends CommonFunctions{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		loadPropertiesFile();
		driver = initializebrowser(prop.getProperty("browser"));
	}
	
	@Test(priority = 1)
	public void verifyTendableLogo()
	{
		WebElement tandebleImage = driver.findElement(By.xpath("//img[@alt='Tendable Logo']"));
		if(tandebleImage.isDisplayed() == true)
		{
			System.out.println("Tendable logo present on Home Page");
		}
	
		//list of items present in the menu
		List<WebElement> listOfMenu = driver.findElements(By.xpath("//nav[@id='main-navigation-new']/ul/li"));
		for(int i=0; i<listOfMenu.size()-1; i++)
		{
			System.out.println(listOfMenu.get(i).getText() + "present on Home Page Menu");
		}
	}

	@Test(priority = 2)
	public void verifyRequestDemo()
	{
		//presence of Request for demo link
		WebElement requestDemo = driver.findElement(By.xpath("//div[@class='button-links-panel']/a[text()='Request a Demo']"));
		if(requestDemo.isDisplayed() == true)
		{
			System.out.println("Demo Request link is present on Search panel");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
