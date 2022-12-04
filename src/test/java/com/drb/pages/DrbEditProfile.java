package com.drb.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class DrbEditProfile extends DrbCreateProfile

{ 	WebDriver driver;
	WebElement edit_prof_button,update_prof_button;
	public DrbEditProfile(WebDriver driver)
	{	super(driver);
		this.driver=driver;
	}

	
	
	public void clickUpdateProfile() throws InterruptedException
	{	Thread.sleep(1000);
		update_prof_button=driver.findElement(By.cssSelector("body > app-root > app-editprofile > div > form > button"));
		try { ((Locatable) update_prof_button).getCoordinates().inViewPort();
		update_prof_button.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        update_prof_button.click();
	       }
		Thread.sleep(500);
		String actual=driver.switchTo().alert().getText();
		String expected="Profile Updated";
		Assert.assertEquals(actual, expected);
		driver.switchTo().alert().accept();
		
	}
	public void higherSecondaryStream(String highersec) throws InterruptedException
	{   
	    higherSecStrm= driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[8]/select"));
	    Thread.sleep(1000);
		Select sel=new Select(higherSecStrm);
		sel.selectByValue(highersec);
		
	}
	public void clickEditProfilebtn() throws InterruptedException {
		
		System.out.println(this);
		Thread.sleep(1000);
		edit_prof_button=driver.findElement(By.linkText("Edit Profile"));
		edit_prof_button.click();
		
	}
	public void setLanguage(String lang) throws InterruptedException
	{
		Thread.sleep(1000);
		 WebElement add = driver.findElement(By.cssSelector("body > app-root > app-editprofile > div > form > table:nth-child(17) > tr > th:nth-child(2) > button"));
	       try { ((Locatable) add).getCoordinates().inViewPort();
	        add.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        add.click();
	       }
	       
	    language=driver.findElement(By.xpath("//input[contains(@formcontrolname,'languages')]"));
		language.sendKeys(lang);
	}
	public void setHighersecSchool(String higersecSchool)
	{
		higherSecSchool=driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[8]/input[2]"));
		higherSecSchool.clear();
		higherSecSchool.sendKeys(higersecSchool);
	}

	public void setHighersecYear(String higersecYear)
	{
		higherSecYear=	driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[8]/input[3]"));
		higherSecYear.clear();
		higherSecYear.sendKeys(higersecYear);
		
	}
	public void setHighersecPercentage(String higersecPercent)
	{
		higherSecPercentage=driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[8]/input[1]"));
		higherSecPercentage.clear();
		higherSecPercentage.sendKeys(higersecPercent);
		
	}
	public void setGraduationStream(String gradStream)
	{
		graduationStream=driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[9]/select[2]"));
		Select sel=new Select(graduationStream);
		sel.selectByValue(gradStream);
	}

	public void setGraduation(String grad) {
		graduation=driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[9]/select[1]"));
		Select sel=new Select(graduation);
		sel.selectByValue(grad);
		
	}

	public void setGraduationPercentage(String gradPercent) {
		
		gradPercentage=driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[9]/input[1]"));
		gradPercentage.clear();
		gradPercentage.sendKeys(gradPercent);
	}

	public void setGraduationInstitute(String gradInst)
	{
		gradInstitute=driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[9]/input[2]"));
		gradInstitute.clear();
		gradInstitute.sendKeys(gradInst);
	}

	public void setGraduationYear(String gradYr)
	{
		gradYear=driver.findElement(By.xpath("/html/body/app-root/app-editprofile/div/form/p[9]/input[3]"));
		gradYear.clear();
		gradYear.sendKeys(gradYr);
	}

	public void setProjectDetails(String project, String projectDesc) {
		projectAdd=driver.findElement(By.cssSelector("body > app-root > app-editprofile > div > form > table:nth-child(13) > tr:nth-child(1) > th:nth-child(2) > button"));
		try { ((Locatable) projectAdd).getCoordinates().inViewPort();
		projectAdd.click();
        }
       catch(Exception e)
        {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        projectAdd.click();
         }
		projectTitle=driver.findElement(By.xpath("//input[@formcontrolname='title']"));
		projectTitle.sendKeys(project);
		projectDescription=driver.findElement(By.xpath("//input[@formcontrolname='desc']"));
		projectDescription.sendKeys(projectDesc);
		
	}

	public void setAchievements(String achievements)
	{
		achievementAdd=driver.findElement(By.cssSelector("body > app-root > app-editprofile > div > form > table:nth-child(19) > tr > th:nth-child(2) > button"));
		try
		{ ((Locatable) achievementAdd).getCoordinates().inViewPort();
		achievementAdd.click();
		}
		catch(Exception e)
		{
			new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
			achievementAdd.click();
		}
		achievement=driver.findElement(By.xpath("//input[@formcontrolname='achievements']"));
		achievement.clear();
		achievement.sendKeys(achievements);
				
	}
	
	
}
