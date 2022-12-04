package com.drb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DrbLogin
{
	WebDriver driver;
	WebElement signup,username,password,rem,login;
	public DrbLogin(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void clickSignUp()
	{
		signup=driver.findElement(By.cssSelector("#navbar-wd > ul > li:nth-child(7) > a"));
		signup.click();
	}
	public void setUserName(String userName) throws InterruptedException
	{
		username=driver.findElement(By.name("Username"));
		username.sendKeys(userName);
		 // Thread.sleep(200);
	}
	public void setPassword(String pass) throws InterruptedException
	{
		password=driver.findElement(By.name("pass"));
		password.sendKeys(pass);
		  //Thread.sleep(200);
	}
	public void clickRememberMe()
	{
		rem=driver.findElement(By.className("label-checkbox100"));
		rem.click();
	}
	public void loginClick()
	{
		login=driver.findElement(By.className("login100-form-btn"));
		login.click();
	}
}