package com.drb.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.testng.Assert;

public class DrbDownload {
	WebDriver driver;
	public DrbDownload(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickTemplateBtn() throws InterruptedException
	{
	WebElement templatelnk=driver.findElement(By.cssSelector("#navbar-wd > ul > li:nth-child(5) > a"))	;
	templatelnk.click();
	Thread.sleep(1000);
		
	}
	public void clickTemplate(String path) throws InterruptedException
	{
//	List<WebElement> temp=driver.findElements(By.tagName("figcaption"));
//	temp.get(3).click();
		WebElement temp=driver.findElement(By.cssSelector(path));
		temp.click();
		
	}
	public void clickDownloadResume(String path) throws InterruptedException
	{
		Thread.sleep(1000);
	WebElement dr=driver.findElement(By.cssSelector(path));
	 
	 try { ((Locatable) dr).getCoordinates().inViewPort();
     dr.click();
     }
    catch(Exception e)
    {
     new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
     dr.click();

    } 
	 String expected1="Download Started";
	 String expected2="Download started";
	 String actual=driver.switchTo().alert().getText();
	 
	 assertTrue(actual.equals(expected1) || actual.equals(expected2));
	 driver.switchTo().alert().accept();
	}
	

}