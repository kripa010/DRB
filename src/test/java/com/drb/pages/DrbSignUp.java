package com.drb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DrbSignUp {
	WebDriver driver;
	WebElement signup,signuplnk,username,passwd,phone,emailid,cpasswd,register;
public DrbSignUp(WebDriver driver)
{
this.driver=driver;
}
	public void clickSignUp()
	{
		signup=driver.findElement(By.cssSelector("#navbar-wd > ul > li:nth-child(7) > a"));
		signup.click();
		
	}

	public void clickSignupLink()
	{
		signuplnk=driver.findElement(By.cssSelector("body > app-root > app-login > div > div > div > form > div.text-center.p-t-46.p-b-20 > span > a"));
		signuplnk.click();
	}

	public void setUserName(String name)
	{
		username=driver.findElement(By.cssSelector("body > app-root > app-signup > div > div > form > div:nth-child(2) > input"));
		username.sendKeys(name);
	}

	public void setPhoneNumber(String phonenumber)
	{
		phone=driver.findElement(By.cssSelector("body > app-root > app-signup > div > div > form > div:nth-child(3) > input"));
		phone.sendKeys(phonenumber);
	}

	public void setMailId(String email)
	{
		emailid=driver.findElement(By.cssSelector("body > app-root > app-signup > div > div > form > div:nth-child(4) > input"));	
		emailid.sendKeys(email);
	}

	public void setPassword(String pass)
	{
		passwd=driver.findElement(By.cssSelector("body > app-root > app-signup > div > div > form > div:nth-child(5) > input"));
		passwd.sendKeys(pass);
		
	}
	

	public void setConfirmPassword(String cpass) {
		cpasswd=driver.findElement(By.cssSelector("body > app-root > app-signup > div > div > form > div:nth-child(6) > input"));
		cpasswd.sendKeys(cpass);
		
	}

	public void clickRegister() {
		register=driver.findElement(By.cssSelector("body > app-root > app-signup > div > div > form > button"));
		register.click();
		
		
	}

}