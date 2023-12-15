package com.tendable.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
WebDriver driver;
	
	@FindBy(xpath = "//div[@class='button-links-panel']/a[text()='Contact Us']")
	private WebElement contactUsButton;

	@FindBy(xpath = "//div[@class='flex']//div/div[contains(text(),'Marketing')]/following-sibling::div/button[contains(text(),'Contact')]")
	private WebElement contactMarketing;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyContactUsButton()
	{
		contactUsButton.click();
	}
	
	public void verifycontactMarketingButton()
	{
		contactMarketing.click();
	}
}
