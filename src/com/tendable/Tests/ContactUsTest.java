package com.tendable.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tendable.CommonFunctions.CommonFunctions;
import com.tendable.Pages.ContactUsPage;

public class ContactUsTest extends CommonFunctions{
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		loadPropertiesFile();
		driver = initializebrowser(prop.getProperty("browser"));
	}
	
	@Test
	public void contactUsTest()
	{
		ContactUsPage contactUsPage = new ContactUsPage(driver);
		contactUsPage.verifyContactUsButton();
		//driver.findElement(By.xpath("//div[@class='button-links-panel']/a[text()='Contact Us']")).click();
		
		//Contact xpath
		
		//driver.findElement(By.xpath("//div[@class='flex']//div/div[contains(text(),'Marketing')]/following-sibling::div/button[contains(text(),'Contact')]")).click();
		contactUsPage.verifycontactMarketingButton();
		//send Full name
		driver.findElement(By.id("form-input-fullName")).sendKeys(dataProp.getProperty("fullName"));
		
		//send Organisation name
		driver.findElement(By.id("form-input-organisationName")).sendKeys(dataProp.getProperty("organizationName"));
		
		//enter phonme number
		driver.findElement(By.id("form-input-cellPhone")).sendKeys(dataProp.getProperty("phoneNumber"));
		
		//enter email id
		driver.findElement(By.id("form-input-email")).sendKeys(dataProp.getProperty("emailId"));
		
		//enter job role
		WebElement roles = driver.findElement(By.id("form-input-jobRole"));
		Select rolesList = new Select(roles);
		List<WebElement> listOfRoleOptions = rolesList.getOptions();
		for(WebElement options : listOfRoleOptions)
		{
			if(options.getText().equals("Management"))
			{
				options.click();
				break;
			}
		}
		
		//I Agree radio button
		driver.findElement(By.id("form-input-consentAgreed-0")).click();
		
		driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//button[@type='submit']")).click();

		String errorMessage = driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']/div/p")).getText();
		System.out.println(errorMessage);
		String expectedErrorMessage = "Sorry, there was an error submitting the form. Please try again.";
		Assert.assertTrue(errorMessage.contains(expectedErrorMessage), expectedErrorMessage);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
