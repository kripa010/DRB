package com.drb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DrbDeleteProfile {
	WebDriver driver;

	public void deleteProfile() throws InterruptedException
	{
		WebElement myprofile=driver.findElement(By.cssSelector("#navbar-wd > ul > li:nth-child(6) > a"));
		myprofile.click();
		Thread.sleep(1000);
		WebElement dltprofile=driver.findElement(By.linkText("Delete Profile"));
		dltprofile.click();
		String actual=driver.switchTo().alert().getText();
		String expected="Are you sure ,you want to delete your profile?";
		Assert.assertEquals(actual, expected);
		driver.switchTo().alert().accept();
	}

	public DrbDeleteProfile(WebDriver driver)
	{
		this.driver = driver;
	}

}