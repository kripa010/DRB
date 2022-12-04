package com.drb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DrbLogout {
	WebDriver driver;
	
	public DrbLogout(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickLogout() {
		WebElement lout=driver.findElement(By.cssSelector("#navbar-wd > ul > li:nth-child(8) > a"));
		//WebElement lout=driver.findElement(By.className("logout btn"));
		lout.click();
		
		
	}

}